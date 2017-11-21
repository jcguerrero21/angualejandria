package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.config.SecurityConfig;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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

    @RequestMapping(value = "/olvidarPassword", method = RequestMethod.POST)
    public ResponseEntity olvidarPasswordPost(
            HttpServletRequest request,
            @RequestBody HashMap<String, String> mapper
    ) throws Exception {
        Usuario usuario = userService.getByEmail(mapper.get("email"));

        if (usuario == null) {
            return new ResponseEntity("Email no encontrado", HttpStatus.BAD_REQUEST);
        }

        String password = SecurityUtility.randomPassword();

        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        usuario.setPassword(encryptedPassword);
        userService.guardar(usuario);

        SimpleMailMessage nuevoEmail = mailConstructor.constructNewUserEmail(usuario, password);
        mailEnviado.send(nuevoEmail);

        return new ResponseEntity("Email enviado", HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizarUsuarioInfo", method = RequestMethod.POST)
    public ResponseEntity perfilInfo(
            @RequestBody HashMap<String, Object> mapper) throws Exception {

        int id = (Integer) mapper.get("id");
        String email = (String) mapper.get("email");
        String username = (String) mapper.get("username");
        String nombre = (String) mapper.get("nombre");
        String apellidos = (String) mapper.get("apellidos");
        String nuevaPassword = (String) mapper.get("nuevaPassword");
        String passwordActual = (String) mapper.get("passwordActual");

        Usuario usuarioActual = userService.getById(Long.valueOf(id));

        if (usuarioActual == null) {
            throw new Exception("Usuario no encontrado");
        }

        if (userService.getByEmail(email) != null) {
            if (userService.getByEmail(email).getId() != usuarioActual.getId()) {
                return new ResponseEntity("Email ya en uso", HttpStatus.BAD_REQUEST);
            }
        }

        if (userService.getByEmail(username) != null) {
            if (userService.getByEmail(username).getId() != usuarioActual.getId()) {
                return new ResponseEntity("Username ya en uso", HttpStatus.BAD_REQUEST);
            }
        }

        SecurityConfig securityConfig = new SecurityConfig();


        BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
        String dbPassword = usuarioActual.getPassword();

        if(null != passwordActual)
        if (passwordEncoder.matches(passwordActual, dbPassword)) {
            if (nuevaPassword != null && !nuevaPassword.isEmpty() && !nuevaPassword.equals("")) {
                usuarioActual.setPassword(passwordEncoder.encode(nuevaPassword));
            }
            usuarioActual.setEmail(email);
        } else {
            return new ResponseEntity("Contraseña actual incorrecta", HttpStatus.BAD_REQUEST);
        }


        usuarioActual.setNombre(nombre);
        usuarioActual.setApellidos(apellidos);
        usuarioActual.setUsername(username);
        usuarioActual.setEmail(email);

        userService.guardar(usuarioActual);

        return new ResponseEntity("Acutalización correcta", HttpStatus.OK);
    }

    @RequestMapping("/getUsuarioActual")
    public Usuario getUsuarioActual(Principal principal) {

        Usuario user = new Usuario();
        if (null != principal) {
            user = userService.getByUsername(principal.getName());
        }

        return user;
    }

}
