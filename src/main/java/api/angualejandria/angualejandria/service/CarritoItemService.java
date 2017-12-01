package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.CarritoCompra;
import api.angualejandria.angualejandria.domain.CarritoItem;
import api.angualejandria.angualejandria.domain.Libro;
import api.angualejandria.angualejandria.domain.Usuario;

import java.util.List;

public interface CarritoItemService {

    /**
     * método para añadir un libro al carrito
     *
     * @param libro
     * @param usuario
     * @param cantidad
     * @return
     */
    CarritoItem addLibroCarritoItem(Libro libro, Usuario usuario, int cantidad);

    /**
     * método para obtener el listao de objetos del carrito de la compra completo
     *
     * @param carritoCompra
     * @return
     */
    List<CarritoItem> getByCarritoCompra(CarritoCompra carritoCompra);

//    List<CarritoItem> getByOrder(Order oder);

    /**
     * método para actualizar los items del carrito de la compra
     *
     * @param carritoItem
     * @return
     */
    CarritoItem actualizarCarritoItem(CarritoItem carritoItem);

    /**
     * método para borrar el carrito
     *
     * @param carritoItem
     */
    void borrarCarritoItem(CarritoItem carritoItem);

    /**
     * método para obtener el carrito
     *
     * @param id
     * @return
     */
    CarritoItem getById(Long id);

    /**
     * método para guardar un item en el carrito
     *
     * @param carritoItem
     * @return
     */
    CarritoItem guardar(CarritoItem carritoItem);
}
