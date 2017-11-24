package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.UsuarioFacturacion;
import api.angualejandria.angualejandria.domain.UsuarioPago;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;

import java.util.Set;

/**
 * Created by Juan Carlos on 10/11/2017.
 */
public interface UserService {

    /**
     * m�todo para crear los usuarios
     *
     * @param usuario
     * @param usuarioRoles
     * @return
     */
    Usuario crearUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles);

    /**
     * m�todo para obtener el usuario por su nombre
     *
     * @param username
     * @return
     */
    Usuario getByUsername(String username);

    /**
     * m�todo para guardar un usuario
     *
     * @param usuario
     * @return
     */
    Usuario guardar(Usuario usuario);

    /**
     * m�todo para obtener un usuario por su id
     *
     * @param id
     * @return
     */
    Usuario getById(Long id);

    /**
     * m�todo para obetner el usuario por su email
     *
     * @param email
     * @return
     */
    Usuario getByEmail(String email);

    /**
     * m�todo para actualizar el pago de un usuario
     *
     * @param usuarioFacturacion
     * @param usuarioPago
     * @param usuario
     */
    void actualizarPagoUsuarioInfo(UsuarioFacturacion usuarioFacturacion, UsuarioPago usuarioPago, Usuario usuario);

    /**
     * m�todo para actualizar la facturaci�n del usuario
     *
     * @param usuarioFacturacion
     * @param usuarioPago
     * @param usuario
     */
    void actualizarUsuarioFacturacion(UsuarioFacturacion usuarioFacturacion, UsuarioPago usuarioPago, Usuario usuario);

    /**
     * m�todo para establecer el pago predeterminado
     *
     * @param usuarioPagoId
     * @param usuario
     */
    void establecerPagoPredeterminado(Long usuarioPagoId, Usuario usuario);
}
