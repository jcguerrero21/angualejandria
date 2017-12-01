package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CarritoCompra implements Serializable {

    private static final long serialVersionUID = -891273432L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal GranTotal;

    @OneToMany(mappedBy = "carritoCompra", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private List<CarritoItem> carritoItemList;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getGranTotal() {
        return GranTotal;
    }

    public void setGranTotal(BigDecimal granTotal) {
        GranTotal = granTotal;
    }

    public List<CarritoItem> getCarritoItemList() {
        return carritoItemList;
    }

    public void setCarritoItemList(List<CarritoItem> carritoItemList) {
        this.carritoItemList = carritoItemList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
