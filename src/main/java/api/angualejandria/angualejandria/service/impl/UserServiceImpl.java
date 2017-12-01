package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.*;
import api.angualejandria.angualejandria.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Juan Carlos on 10/11/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioFacturacionRepository usuarioFacturacionRepository;

    @Autowired
    private UsuarioPagoRepository usuarioPagoRepository;

    @Autowired
    private UsuarioEnvioRepository usuarioEnvioRepository;

    @Transactional
    public Usuario crearUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) {
        Usuario localUser = userRepository.findByUsername(usuario.getUsername());

        if (localUser != null) {
            LOG.info(("El usuario con el nombre username {} ya existe."), usuario.getUsername());
        } else {

            for (UsuarioRol userRol : usuarioRoles) {
                rolRepository.save(userRol.getRol());
            }

            usuario.getUsuarioRoles().addAll(usuarioRoles);

            CarritoCompra carritoCompra = new CarritoCompra();
            carritoCompra.setUsuario(usuario);
            usuario.setCarritoCompra(carritoCompra);

            usuario.setUsuarioPagoList(new ArrayList<UsuarioPago>());
            usuario.setUsuarioEnvioList(new ArrayList<UsuarioEnvio>());

            localUser = userRepository.save(usuario);
        }

        return localUser;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Usuario getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Usuario getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Usuario getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void actualizarPagoUsuarioInfo(UsuarioFacturacion usuarioFacturacion, UsuarioPago usuarioPago, Usuario usuario) {
        guardar(usuario);
        usuarioFacturacionRepository.save(usuarioFacturacion);
        usuarioPagoRepository.save(usuarioPago);
    }

    @Override
    public void actualizarUsuarioFacturacion(UsuarioFacturacion usuarioFacturacion, UsuarioPago usuarioPago, Usuario usuario) {
        usuarioPago.setUsuario(usuario);
        usuarioPago.setUsuarioFacturacion(usuarioFacturacion);
        usuarioPago.setPagoPredeterminado(true);
        usuarioFacturacion.setUsuarioPago(usuarioPago);
        usuario.getUsuarioPagoList().add(usuarioPago);
        guardar(usuario);
    }

    @Override
    public void establecerPagoPredeterminado(Long usuarioPagoId, Usuario usuario) {
        List<UsuarioPago> usuarioPagoList = (List<UsuarioPago>) usuarioPagoRepository.findAll();

        for (UsuarioPago usuarioPago: usuarioPagoList) {
            if(usuarioPago.getId() == usuarioPagoId) {
                usuarioPago.setPagoPredeterminado(true);
                usuarioPagoRepository.save(usuarioPago);
            } else {
                usuarioPago.setPagoPredeterminado(false);
                usuarioPagoRepository.save(usuarioPago);
            }
        }
    }

    @Override
    public void actualizarUsuarioEnvio(UsuarioEnvio usuarioEnvio, Usuario usuario) {
        usuarioEnvio.setUsuario(usuario);
        usuarioEnvio.setUsuarioEnvioPredeterminado(true);
        usuario.getUsuarioEnvioList().add(usuarioEnvio);
        guardar(usuario);
    }

    @Override
    public void establecerEnvioPredeterminado(Long usuarioEnvioId, Usuario usuario) {
        List<UsuarioEnvio> usuarioEnvioList = (List<UsuarioEnvio>) usuarioEnvioRepository.findAll();

        for (UsuarioEnvio usuarioEnvio: usuarioEnvioList) {
            if(usuarioEnvio.getId() == usuarioEnvioId) {
                usuarioEnvio.setUsuarioEnvioPredeterminado(true);
                usuarioEnvioRepository.save(usuarioEnvio);
            } else {
                usuarioEnvio.setUsuarioEnvioPredeterminado(false);
                usuarioEnvioRepository.save(usuarioEnvio);
            }
        }
    }
}
