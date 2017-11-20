package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.repository.RolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;
import api.angualejandria.angualejandria.repository.UserRepository;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
