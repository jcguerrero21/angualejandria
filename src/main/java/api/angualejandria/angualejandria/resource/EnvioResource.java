package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.UsuarioEnvio;
import api.angualejandria.angualejandria.service.UserService;
import api.angualejandria.angualejandria.service.UsuarioEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/envio")
public class EnvioResource {

    @Autowired
    private UserService usuarioService;

    @Autowired
    private UsuarioEnvioService usuarioEnvioService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addNuevoUsuarioPost(
            @RequestBody UsuarioEnvio usuarioEnvio, Principal principal
            ) {
        Usuario usuario = usuarioService.getByUsername(principal.getName());
        usuarioService.actualizarUsuarioEnvio(usuarioEnvio, usuario);

        return new ResponseEntity("Envio añadido correctamente", HttpStatus.OK);
    }

    @RequestMapping("/getUsuarioEnvioLista")
    public List<UsuarioEnvio> getUsuarioEnvioList(
            Principal principal){
            Usuario usuario = usuarioService.getByUsername(principal.getName());
            List<UsuarioEnvio> usuarioEnvioList = usuario.getUsuarioEnvioList();

            return usuarioEnvioList;
    }

    @RequestMapping(value="/borrar", method = RequestMethod.POST)
    public ResponseEntity borrarUsuarioEnvioPost(
            @RequestBody String id,
            Principal principal
            ) {
        usuarioEnvioService.borrarById(Long.valueOf(id));
        return new ResponseEntity("Envio borrado correctamente", HttpStatus.OK);
    }

    @RequestMapping(value="/establecerEnvioDeterminado", method = RequestMethod.POST)
    public ResponseEntity establecerPredeterminadoUsuarioEnvioPost(
            @RequestBody String id,
            Principal principal
            ){
        Usuario usuario = usuarioService.getByUsername(principal.getName());
        usuarioService.establecerEnvioPredeterminado(Long.parseLong(id),usuario);

        return new ResponseEntity("Envio Predeterminado cambiado Correctamente", HttpStatus.OK);
    }




}
