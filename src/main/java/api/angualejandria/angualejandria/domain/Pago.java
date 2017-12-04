package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pago implements Serializable{
    private static final long serialVersionUID = 79151235145L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String numeroTarjeta;
    private int mesExpiracion;
    private int anioExpiracion;
    private int cvc;
    private String nombreTitular;
    private boolean pagoPredeterminado;

    @OneToOne
    @JsonIgnore
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMesExpiracion() {
        return mesExpiracion;
    }

    public void setMesExpiracion(int mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public int getAnioExpiracion() {
        return anioExpiracion;
    }

    public void setAnioExpiracion(int anioExpiracion) {
        this.anioExpiracion = anioExpiracion;
    }

    public boolean isPagoPredeterminado() {
        return pagoPredeterminado;
    }

    public void setPagoPredeterminado(boolean pagoPredeterminado) {
        this.pagoPredeterminado = pagoPredeterminado;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public Boolean getPagoPredeterminado() {
        return pagoPredeterminado;
    }

    public void setPagoPredeterminado(Boolean pagoPredeterminado) {
        this.pagoPredeterminado = pagoPredeterminado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
