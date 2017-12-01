package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.CarritoCompra;
import api.angualejandria.angualejandria.domain.CarritoItem;
import api.angualejandria.angualejandria.repository.CarritoCompraRepository;
import api.angualejandria.angualejandria.service.CarritoCompraService;
import api.angualejandria.angualejandria.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {

    @Autowired
    private CarritoItemService carritoItemService;

    @Autowired
    private CarritoCompraRepository carritoCompraRepository;

    public CarritoCompra actualizarCarritoCompra(CarritoCompra carritoCompra) {
        BigDecimal carritoTotal = new BigDecimal(0);

        List<CarritoItem> carritoItemList = carritoItemService.getByCarritoCompra(carritoCompra);

        for (CarritoItem carritoItem : carritoItemList) {
            if (carritoItem.getLibro().getNumeroDeStock() > 0) {
                carritoItemService.actualizarCarritoItem(carritoItem);
                carritoTotal = carritoTotal.add(carritoItem.getSubtotal());
            }
        }

        carritoCompra.setGranTotal(carritoTotal);

        carritoCompraRepository.save(carritoCompra);

        return carritoCompra;
    }

    public void limpiarCarritoCompra(CarritoCompra carritoCompra){
        List<CarritoItem> carritoItemList = carritoItemService.getByCarritoCompra(carritoCompra);

        for (CarritoItem carritoItem : carritoItemList) {
            carritoItem.setCarritoCompra(null);
            carritoItemService.guardar(carritoItem);
        }

        carritoCompra.setGranTotal(new BigDecimal(0));

        carritoCompraRepository.save(carritoCompra);
    }
}
