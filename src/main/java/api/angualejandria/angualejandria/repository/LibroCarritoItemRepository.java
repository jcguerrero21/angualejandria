package api.angualejandria.angualejandria.repository;

import api.angualejandria.angualejandria.domain.CarritoItem;
import api.angualejandria.angualejandria.domain.LibroCarritoItem;
import org.springframework.data.repository.CrudRepository;

public interface LibroCarritoItemRepository extends CrudRepository<LibroCarritoItem, Long>{
    void deleteByCarritoItem(CarritoItem carritoItem);
}
