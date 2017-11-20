package api.angualejandria.angualejandria.utilidades;

import api.angualejandria.angualejandria.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Juan Carlos on 20/11/2017.
 */

@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructNewUserEmail(Usuario user, String password) {
        String message="\nPlease use the following credentials to log in and edit your personal information including your own password."
                + "\n\n\nUsuario: "+user.getUsername()+"\nContraseña: "+password;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("AnguAlejandria - Nuevo Usuario");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
