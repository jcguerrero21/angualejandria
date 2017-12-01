package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.*;
import api.angualejandria.angualejandria.repository.CarritoItemRepository;
import api.angualejandria.angualejandria.repository.LibroCarritoItemRepository;
import api.angualejandria.angualejandria.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarritoItemServiceImpl implements CarritoItemService {

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Autowired
    private LibroCarritoItemRepository libroCarritoItemRepository;

    @Override
    public CarritoItem addLibroCarritoItem(Libro libro, Usuario usuario, int cantidad) {
        List<CarritoItem> carritoItemList = getByCarritoCompra(usuario.getCarritoCompra());

        for (CarritoItem carritoItem: carritoItemList) {
            if(libro.getId() == carritoItem.getLibro().getId()) {
                carritoItem.setCantidad(carritoItem.getCantidad()+cantidad);
                carritoItem.setSubtotal(new BigDecimal(libro.getNuestroPrecio()).multiply(new BigDecimal(cantidad)));
                carritoItemRepository.save(carritoItem);
                return carritoItem;
            }
        }

        CarritoItem carritoItem = new CarritoItem();
        carritoItem.setCarritoCompra(usuario.getCarritoCompra());
        carritoItem.setLibro(libro);
        carritoItem.setCantidad(cantidad);
        carritoItem.setSubtotal(new BigDecimal(libro.getNuestroPrecio()).multiply(new BigDecimal(cantidad)));

        carritoItem = carritoItemRepository.save(carritoItem);

        LibroCarritoItem libroCarritoItem = new LibroCarritoItem();
        libroCarritoItem.setLibro(libro);
        libroCarritoItem.setCarritoItem(carritoItem);
        libroCarritoItemRepository.save(libroCarritoItem);

        return carritoItem;
    }

    public void borrarCarritoItem(CarritoItem carritoItem) {
        libroCarritoItemRepository.deleteByCarritoItem(carritoItem);
        carritoItemRepository.delete(carritoItem);
    }

    public List<CarritoItem> getByCarritoCompra(CarritoCompra carritoCompra) {
        return carritoItemRepository.findByCarritoCompra(carritoCompra);
    }

    public CarritoItem actualizarCarritoItem(CarritoItem carritoItem) {
        BigDecimal bigDecimal = new BigDecimal(carritoItem.getLibro().getNuestroPrecio()).multiply(new BigDecimal(carritoItem.getCantidad()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        carritoItem.setSubtotal(bigDecimal);

        carritoItemRepository.save(carritoItem);

        return carritoItem;
    }

    public CarritoItem getById(Long id) {
        return carritoItemRepository.findOne(id);
    }

    public CarritoItem guardar(CarritoItem carritoItem) {
        return carritoItemRepository.save(carritoItem);
    }

//    public List<CarritoItem> getByOrder(Order order) {
//        return carritoItemRepository.getByOrder(order);
//    }
}
