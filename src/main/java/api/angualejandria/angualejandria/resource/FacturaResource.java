package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Factura;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.service.FacturaService;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaResource {

    @Autowired
    private UserService userService;

    @Autowired
    private FacturaService facturaService;

    @RequestMapping("/getFacturaLista")
    public List<Factura> getFacturaLista(Principal principal) {
        Usuario usuario = userService.getByUsername(principal.getName());
        List<Factura> facturaList = usuario.getFacturaList();

        return facturaList;
    }

    @RequestMapping("/getAllFacturas")
    public List<Factura> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @RequestMapping(value = "/enviarPedido", method = RequestMethod.POST)
    public ResponseEntity enviarFactura(@RequestBody Factura factura) throws IOException {
        facturaService.enviarUno(factura);

        return new ResponseEntity("Pedido Enviado Correctamente", HttpStatus.OK);
    }
}
