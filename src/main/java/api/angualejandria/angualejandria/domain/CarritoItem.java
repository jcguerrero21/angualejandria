package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CarritoItem implements Serializable {

    private static final long serialVersionUID = -189412481L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cantidad;
    private BigDecimal subtotal;

    @OneToOne
    private Libro libro;

    @OneToMany(mappedBy ="carritoItem")
    @JsonIgnore
    private List<LibroCarritoItem> libroCarritoItemList;

    @ManyToOne
    @JoinColumn(name="carrito_compra_id")
    @JsonIgnore
    private CarritoCompra carritoCompra;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnore
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<LibroCarritoItem> getLibroCarritoItemList() {
        return libroCarritoItemList;
    }

    public void setLibroCarritoItemList(List<LibroCarritoItem> libroCarritoItemList) {
        this.libroCarritoItemList = libroCarritoItemList;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
