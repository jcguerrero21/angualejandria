package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.*;
import api.angualejandria.angualejandria.repository.EnvioCalleRepository;
import api.angualejandria.angualejandria.repository.FacturaRepository;
import api.angualejandria.angualejandria.repository.FacturacionCalleRepository;
import api.angualejandria.angualejandria.repository.PagoRepository;
import api.angualejandria.angualejandria.service.CarritoItemService;
import api.angualejandria.angualejandria.service.FacturaService;
import api.angualejandria.angualejandria.service.LibroService;
import api.angualejandria.angualejandria.utilidades.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturacionCalleRepository facturacionCalleRepository;

    @Autowired
    private EnvioCalleRepository envioCalleRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CarritoItemService carritoItemService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private MailConstructor mailConstructor;

    public Factura crearPedido(CarritoCompra carritoCompra, EnvioCalle envioCalle, FacturacionCalle facturacionCalle, Pago pago, String metodoEnvio, Usuario usuario) {
        Factura factura = new Factura();
        factura.setFacturacionCalle(facturacionCalle);
        factura.setEstadoFactura("creada");
        factura.setEnvioCalle(envioCalle);
        factura.setMetodoEnvio(metodoEnvio);

        List<CarritoItem> carritoItemList = carritoItemService.getByCarritoCompra(carritoCompra);

        for(CarritoItem carritoItem: carritoItemList) {
            Libro libro = carritoItem.getLibro();
            carritoItem.setFactura(factura);
            libro.setNumeroDeStock(libro.getNumeroDeStock()-carritoItem.getCantidad());
        }

        factura.setCarritoItemList(carritoItemList);
        factura.setFechaFactura(Calendar.getInstance().getTime());
        factura.setFacturaTotal(carritoCompra.getGranTotal());
        envioCalle.setFactura(factura);
        facturacionCalle.setFactura(factura);
        pago.setFactura(factura);
        factura.setUsuario(usuario);
        factura = facturaRepository.save(factura);

        return factura;
    }

    public Factura getUna(Long id){
        return facturaRepository.findOne(id);
    }
}
