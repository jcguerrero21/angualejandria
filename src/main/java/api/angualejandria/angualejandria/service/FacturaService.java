package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.*;

import java.util.List;

public interface FacturaService {

    /**
     * Método para crear un pedido o factura
     *
     * @param carritoCompra
     * @param envioCalle
     * @param facturacionCalle
     * @param pago
     * @param metodoEnvio
     * @param usuario
     * @return
     */
    Factura crearPedido(CarritoCompra carritoCompra, EnvioCalle envioCalle, FacturacionCalle facturacionCalle, Pago pago, String metodoEnvio, Usuario usuario);

    /**
     * Método para obtener una única factura
     *
     * @param id
     * @return
     */
    Factura getUna(Long id);

    /**
     * Método par obetener un listado de todas las facturas que estén en estado de creadas
     *
     * @return
     */
    List<Factura> getAllFacturas();

    /**
     * método para actualizar una factura de creada a enviada
     *
     * @param factura
     */
    Factura enviarUno(Factura factura);
}
