package api.angualejandria.angualejandria.service;


import api.angualejandria.angualejandria.domain.CarritoCompra;

public interface CarritoCompraService {

    /**
     * m�todo para actualizar el carrito de la compra
     *
     * @param carritoCompra
     * @return
     */
    CarritoCompra actualizarCarritoCompra(CarritoCompra carritoCompra);

    /**
     * m�todo para limpiar el carrito de la compra
     *
     * @param carritoCompra
     */
    void limpiarCarritoCompra(CarritoCompra carritoCompra);


}
