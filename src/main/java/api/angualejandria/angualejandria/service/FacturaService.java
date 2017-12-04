package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.*;

public interface FacturaService {

    Factura crearPedido(CarritoCompra carritoCompra, EnvioCalle envioCalle, FacturacionCalle facturacionCalle, Pago pago, String metodoEnvio, Usuario usuario);
}
