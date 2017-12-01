package api.angualejandria.angualejandria.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LibroCarritoItem implements Serializable {
    private static final long serialVersionUID = 879172834L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="libro_id")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="carrito_item_id")
    private CarritoItem carritoItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public CarritoItem getCarritoItem() {
        return carritoItem;
    }

    public void setCarritoItem(CarritoItem carritoItem) {
        this.carritoItem = carritoItem;
    }
}
