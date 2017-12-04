package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.*;
import api.angualejandria.angualejandria.service.CarritoCompraService;
import api.angualejandria.angualejandria.service.CarritoItemService;
import api.angualejandria.angualejandria.service.FacturaService;
import api.angualejandria.angualejandria.service.UserService;
import api.angualejandria.angualejandria.utilidades.MailConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/checkout")
public class CheckoutResource {
    private Factura factura = new Factura();

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private CarritoItemService carritoItemService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private CarritoCompraService carritoCompraService;

    @Autowired
    private MailConstructor mailConstructor;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public Factura checkOutPost(
            @RequestBody HashMap<String, Object> mapper,
            Principal principal
            ){
        ObjectMapper om = new ObjectMapper();

        EnvioCalle envioCalle = om.convertValue(mapper.get("envioCalle"), EnvioCalle.class);
        FacturacionCalle facturacionCalle = om.convertValue(mapper.get("facturacionCalle"), FacturacionCalle.class);
        Pago pago = om.convertValue(mapper.get("pago"), Pago.class);
        String metodoEnvio = (String) mapper.get("metodoEnvio");

        CarritoCompra carritoCompra = userService.getByUsername(principal.getName()).getCarritoCompra();
        List<CarritoItem> carritoItemList = carritoItemService.getByCarritoCompra(carritoCompra);
        Usuario usuario = userService.getByUsername(principal.getName());
        Factura factura = facturaService.crearPedido(carritoCompra, envioCalle, facturacionCalle, pago, metodoEnvio, usuario);

        mailSender.send(mailConstructor.constructNewUserEmail(usuario, factura, Locale.ENGLISH));

        carritoCompraService.limpiarCarritoCompra(carritoCompra);

        LocalDate hoy = LocalDate.now();
        LocalDate fechaEstimadaDeEntrega;
        if(metodoEnvio.equals("metodoEnvioNormal")) {
            fechaEstimadaDeEntrega = hoy.plusDays(5);
        } else {
            fechaEstimadaDeEntrega= hoy.plusDays(1);
        }

        this.factura = factura;

        return factura;
    }
}
