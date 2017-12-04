package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "usuario_factura")
public class Factura implements Serializable{
    private static final long serialVersionUID = 2893475845L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaFactura;
    private Date fechaEnvio;
    private String metodoEnvio;
    private String estadoFactura;
    private BigDecimal facturaTotal;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<CarritoItem> carritoItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private EnvioCalle envioCalle;

    @OneToOne(cascade = CascadeType.ALL)
    private FacturacionCalle facturacionCalle;

   @OneToOne(cascade = CascadeType.ALL)
   private Pago pago;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(String metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public BigDecimal getFacturaTotal() {
        return facturaTotal;
    }

    public void setFacturaTotal(BigDecimal facturaTotal) {
        this.facturaTotal = facturaTotal;
    }

    public List<CarritoItem> getCarritoItemList() {
        return carritoItemList;
    }

    public void setCarritoItemList(List<CarritoItem> carritoItemList) {
        this.carritoItemList = carritoItemList;
    }

    public EnvioCalle getEnvioCalle() {
        return envioCalle;
    }

    public void setEnvioCalle(EnvioCalle envioCalle) {
        this.envioCalle = envioCalle;
    }

    public FacturacionCalle getFacturacionCalle() {
        return facturacionCalle;
    }

    public void setFacturacionCalle(FacturacionCalle facturacionCalle) {
        this.facturacionCalle = facturacionCalle;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
