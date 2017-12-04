package api.angualejandria.angualejandria.utilidades;

import api.angualejandria.angualejandria.domain.Factura;
import api.angualejandria.angualejandria.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

/**
 * Created by Juan Carlos on 20/11/2017.
 */

@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

    public SimpleMailMessage constructNewUserEmail(Usuario user, String password) {
        String message="\nUtilice las siguientes credenciales para iniciar sesión y editar su información personal, incluida su propia contraseña."
                + "\n\n\nUsuario: "+user.getUsername()+"\nContraseña: "+password;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("AnguAlejandria - Nuevo Usuario");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    public MimeMessagePreparator construirFacturaConfirmacionEmail (Usuario usuario, Factura factura) {
        Context context = new Context();
        context.setVariable("factura", factura);
        context.setVariable("usuario", usuario);
        context.setVariable("carritoItemList", factura.getCarritoItemList());
        String text = templateEngine.process("facturaConfirmacionEmailTemplate", context);

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                email.setTo(usuario.getEmail());
                email.setSubject("Confirmación De La Factura - "+factura.getId());
                email.setText(text,true);
                email.setFrom(new InternetAddress("jotaceguerrerom21pruebas@gmail.com"));
            }
        };

        return mimeMessagePreparator;
    }
}
