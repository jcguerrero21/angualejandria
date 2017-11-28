package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.UsuarioFacturacion;
import api.angualejandria.angualejandria.domain.UsuarioPago;
import api.angualejandria.angualejandria.service.UserService;
import api.angualejandria.angualejandria.service.UsuarioPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by Juan Carlos on 23/11/2017.
 */

@RestController
@RequestMapping("/pago")
public class PagoResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UsuarioPagoService usuarioPagoService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addNuevaTarjetaCreditoPost(
            @RequestBody UsuarioPago usuarioPago,
            Principal principal) {

        Usuario usuario = userService.getByUsername(principal.getName());

        UsuarioFacturacion usuarioFacturacion = usuarioPago.getUsuarioFacturacion();

        userService.actualizarUsuarioFacturacion(usuarioFacturacion, usuarioPago, usuario);

        return new ResponseEntity("Pago añadido correctamente", HttpStatus.OK);
    }

    @RequestMapping(value="/borrar", method = RequestMethod.POST)
    public ResponseEntity borrarPagoPost(
            @RequestBody String id,
            Principal principal){

//        Usuario usuario = userService.getByUsername(principal.getName());

        usuarioPagoService.borrarById(Long.valueOf(id));

        return new ResponseEntity("Pago borrado correctamente", HttpStatus.OK);
    }

    @RequestMapping(value="/establecerPagoDeterminado", method = RequestMethod.POST)
    public ResponseEntity establecerPagoDeterminado(
            @RequestBody String id,
            Principal principal){

        Usuario usuario = userService.getByUsername(principal.getName());

        userService.establecerPagoPredeterminado(Long.parseLong(id), usuario);

        return new ResponseEntity("Pago  predeterminado establecido correctamente", HttpStatus.OK);
    }

    @RequestMapping("/getUsuarioPagoLista")
    public List<UsuarioPago> getUsuarioPagoLista(Principal principal){

        Usuario usuario = userService.getByUsername(principal.getName());

        List<UsuarioPago> usuarioPagoList = usuario.getUsuarioPagoList();

        return usuarioPagoList;
    }
}
