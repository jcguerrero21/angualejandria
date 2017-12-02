package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.CarritoCompra;
import api.angualejandria.angualejandria.domain.CarritoItem;
import api.angualejandria.angualejandria.domain.Libro;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.service.CarritoCompraService;
import api.angualejandria.angualejandria.service.CarritoItemService;
import api.angualejandria.angualejandria.service.LibroService;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoCompraResource {

    @Autowired
    private UserService userService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private CarritoItemService carritoItemService;

    @Autowired
    private CarritoCompraService carritoCompraService;

    @RequestMapping("/add")
    public ResponseEntity addItem(
            @RequestBody HashMap<String, String> mapper, Principal principal
    ) {
        String libroId = (String) mapper.get("libroId");
        String cantidad = (String) mapper.get("cantidad");

        Usuario usuario = userService.getByUsername(principal.getName());
        Libro libro = libroService.getUno(Long.parseLong(libroId));

        if (Integer.parseInt(cantidad) > libro.getNumeroDeStock()) {
            return new ResponseEntity("No hay Stock", HttpStatus.BAD_REQUEST);
        }

        CarritoItem carritoItem = carritoItemService.addLibroCarritoItem(libro, usuario, Integer.parseInt(cantidad));

        return new ResponseEntity("Libro añadido correctamente", HttpStatus.OK);
    }

    @RequestMapping("/getCarritoListaItem")
    public List<CarritoItem> getCarritoItemList(Principal principal) {
        Usuario usuario = userService.getByUsername(principal.getName());
        CarritoCompra carritoCompra = usuario.getCarritoCompra();

        List<CarritoItem> carritoItemList = carritoItemService.getByCarritoCompra(carritoCompra);

        carritoCompraService.actualizarCarritoCompra(carritoCompra);

        return carritoItemList;
    }

    @RequestMapping("/getCarritoCompra")
    public CarritoCompra getCarritoCompra(Principal principal) {
        Usuario usuario = userService.getByUsername(principal.getName());
        CarritoCompra carritoCompra = usuario.getCarritoCompra();

        carritoCompraService.actualizarCarritoCompra(carritoCompra);

        return carritoCompra;
    }

    @RequestMapping("/borrarCarritoItem")
    public ResponseEntity borrarItem(@RequestBody String id) {
        carritoItemService.borrarCarritoItem(carritoItemService.getById(Long.parseLong(id)));

        return new ResponseEntity("Item borrado del carrito Correctamente", HttpStatus.OK);
    }

    @RequestMapping("/actualizarCarritoItem")
    public ResponseEntity actualizarCarritoItem(
            @RequestBody HashMap<String, String> mapper) {
        String carritoItemId = mapper.get("carritoItemId");
        String cantidad = mapper.get("cantidad");

        CarritoItem carritoItem = carritoItemService.getById(Long.parseLong(carritoItemId));
        carritoItem.setCantidad(Integer.parseInt(cantidad));

        carritoItemService.actualizarCarritoItem(carritoItem);

        return new ResponseEntity("Item del carrito actualizado correctamente", HttpStatus.OK);
    }


}
