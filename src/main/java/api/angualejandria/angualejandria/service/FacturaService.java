package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.*;

import java.util.List;

public interface FacturaService {

    /**
     * M�todo para crear un pedido o factura
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
     * M�todo para obtener una �nica factura
     *
     * @param id
     * @return
     */
    Factura getUna(Long id);

    /**
     * M�todo par obetener un listado de todas las facturas que est�n en estado de creadas
     *
     * @return
     */
    List<Factura> getAllFacturas();

    /**
     * m�todo para actualizar una factura de creada a enviada
     *
     * @param factura
     */
    Factura enviarUno(Factura factura);
}
