package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
public class LoginResource {
    @Autowired
    private UserService userService;

    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request) {
        System.out.println(request.getRemoteHost());

        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();

        System.out.println(remoteHost + ":" + portNumber);
        System.out.println(request.getRemoteAddr());

        return Collections.singletonMap("token", session.getId());
    }

    @RequestMapping("/verificarSesion")
    public ResponseEntity verificarSesion() {
        return new ResponseEntity("Sesion Activa", HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/cerrarSesion", method = RequestMethod.POST)
    public ResponseEntity cerrarSesion(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Sesión cerrado correctamente", HttpStatus.OK);
    }
}
