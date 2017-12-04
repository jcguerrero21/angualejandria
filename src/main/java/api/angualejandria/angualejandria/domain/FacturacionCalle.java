package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FacturacionCalle implements Serializable{
    private static final long serialVersionUID = 78293749582348L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facturacionCalleNombre;
    private String facturacionCalleCalle;
    private String facturacionCalleCiudad;
    private String facturacionCalleProvincia;
    private String facturacionCallePais;
    private String facturacionCalleCodigoPostal;

    @OneToOne
    @JsonIgnore
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacturacionCalleNombre() {
        return facturacionCalleNombre;
    }

    public void setFacturacionCalleNombre(String facturacionCalleNombre) {
        this.facturacionCalleNombre = facturacionCalleNombre;
    }

    public String getFacturacionCalleCalle() {
        return facturacionCalleCalle;
    }

    public void setFacturacionCalleCalle(String facturacionCalleCalle) {
        this.facturacionCalleCalle = facturacionCalleCalle;
    }

    public String getFacturacionCalleCiudad() {
        return facturacionCalleCiudad;
    }

    public void setFacturacionCalleCiudad(String facturacionCalleCiudad) {
        this.facturacionCalleCiudad = facturacionCalleCiudad;
    }

    public String getFacturacionCalleProvincia() {
        return facturacionCalleProvincia;
    }

    public void setFacturacionCalleProvincia(String facturacionCalleProvincia) {
        this.facturacionCalleProvincia = facturacionCalleProvincia;
    }

    public String getFacturacionCallePais() {
        return facturacionCallePais;
    }

    public void setFacturacionCallePais(String facturacionCallePais) {
        this.facturacionCallePais = facturacionCallePais;
    }

    public String getFacturacionCalleCodigoPostal() {
        return facturacionCalleCodigoPostal;
    }

    public void setFacturacionCalleCodigoPostal(String facturacionCalleCodigoPostal) {
        this.facturacionCalleCodigoPostal = facturacionCalleCodigoPostal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
