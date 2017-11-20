package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.config.SecurityUtility;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.security.Rol;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;
import api.angualejandria.angualejandria.service.UserService;
import api.angualejandria.angualejandria.utilidades.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Carlos on 20/11/2017.
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UserService userService;

    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private JavaMailSender mailEnviado;

    @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST)
    public ResponseEntity nuevoUsuarioPost(
            HttpServletRequest request,
            @RequestBody HashMap<String, String> mapper
    ) throws Exception {
        String username = mapper.get("username");
        String userEmail = mapper.get("email");

        if (userService.getByUsername(username) != null) {
            return new ResponseEntity("usernameExiste", HttpStatus.BAD_REQUEST);
        }

        if (userService.getByEmail(userEmail) != null) {
            return new ResponseEntity("emailExiste", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(userEmail);

        String password = SecurityUtility.randomPassword();

        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        usuario.setPassword(encryptedPassword);

        Rol rol = new Rol();
        rol.setRolId(1); //1 es el rol de usuario
        rol.setNombre("ROLE_USER");
        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        usuarioRoles.add(new UsuarioRol(usuario, rol));
        userService.crearUsuario(usuario, usuarioRoles);

        SimpleMailMessage email = mailConstructor.constructNewUserEmail(usuario, password);
        mailEnviado.send(email);

        return new ResponseEntity("Usuario añadido con exito", HttpStatus.OK);
    }
}
