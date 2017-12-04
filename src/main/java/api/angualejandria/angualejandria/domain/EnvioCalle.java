package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EnvioCalle implements Serializable{
    private static final long serialVersionUID = 189013457L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String envioCalleNombre;
    private String envioCalleCalle;
    private String envioCalleCiudad;
    private String envioCalleProvincia;
    private String envioCallePais;
    private String envioCalleCodigoPostal;
    private Boolean envioCallePredeterminado;

    @OneToOne
    @JsonIgnore
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnvioCalleNombre() {
        return envioCalleNombre;
    }

    public void setEnvioCalleNombre(String envioCalleNombre) {
        this.envioCalleNombre = envioCalleNombre;
    }

    public String getEnvioCalleCalle() {
        return envioCalleCalle;
    }

    public void setEnvioCalleCalle(String envioCalleCalle) {
        this.envioCalleCalle = envioCalleCalle;
    }

    public String getEnvioCalleCiudad() {
        return envioCalleCiudad;
    }

    public void setEnvioCalleCiudad(String envioCalleCiudad) {
        this.envioCalleCiudad = envioCalleCiudad;
    }

    public String getEnvioCalleProvincia() {
        return envioCalleProvincia;
    }

    public void setEnvioCalleProvincia(String envioCalleProvincia) {
        this.envioCalleProvincia = envioCalleProvincia;
    }

    public String getEnvioCallePais() {
        return envioCallePais;
    }

    public void setEnvioCallePais(String envioCallePais) {
        this.envioCallePais = envioCallePais;
    }

    public String getEnvioCalleCodigoPostal() {
        return envioCalleCodigoPostal;
    }

    public void setEnvioCalleCodigoPostal(String envioCalleCodigoPostal) {
        this.envioCalleCodigoPostal = envioCalleCodigoPostal;
    }

    public Boolean getEnvioCallePredeterminado() {
        return envioCallePredeterminado;
    }

    public void setEnvioCallePredeterminado(Boolean envioCallePredeterminado) {
        this.envioCallePredeterminado = envioCallePredeterminado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
