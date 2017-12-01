package api.angualejandria.angualejandria.repository;

import api.angualejandria.angualejandria.domain.CarritoCompra;
import api.angualejandria.angualejandria.domain.CarritoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarritoItemRepository extends CrudRepository<CarritoItem, Long> {

    List<CarritoItem> findByCarritoCompra(CarritoCompra carritoCompra);

//    List<CarritoItem> getByOrder(Order oder);

}
