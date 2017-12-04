package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Factura;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/getFacturaLista")
    public List<Factura> getFacturaLista(Principal principal){
        Usuario usuario = userService.getByUsername(principal.getName());
        List<Factura> facturaList = usuario.getFacturaList();

        return facturaList;

    }
}
