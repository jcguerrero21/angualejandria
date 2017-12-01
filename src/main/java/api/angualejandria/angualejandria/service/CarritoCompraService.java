package api.angualejandria.angualejandria.service;


import api.angualejandria.angualejandria.domain.CarritoCompra;

public interface CarritoCompraService {

    /**
     * método para actualizar el carrito de la compra
     *
     * @param carritoCompra
     * @return
     */
    CarritoCompra actualizarCarritoCompra(CarritoCompra carritoCompra);

    /**
     * método para limpiar el carrito de la compra
     *
     * @param carritoCompra
     */
    void limpiarCarritoCompra(CarritoCompra carritoCompra);


}
