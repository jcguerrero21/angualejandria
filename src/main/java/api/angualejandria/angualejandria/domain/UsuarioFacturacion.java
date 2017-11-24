package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Juan Carlos on 23/11/2017.
 */

@Entity
public class UsuarioFacturacion implements Serializable{

    private static final long serialVersionUID = 79872894528934L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String usuarioFacturacionNombre;
    private String usuarioFacturacionCalle;
    private String usuarioFacturacionCiudad;
    private String usuarioFacturacionProvincia;
    private String usuarioFacturacionPais;
    private String usuarioFacturacionCodigoPostal;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UsuarioPago usuarioPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioFacturacionNombre() {
        return usuarioFacturacionNombre;
    }

    public void setUsuarioFacturacionNombre(String usuarioFacturacionNombre) {
        this.usuarioFacturacionNombre = usuarioFacturacionNombre;
    }

    public String getUsuarioFacturacionCalle() {
        return usuarioFacturacionCalle;
    }

    public void setUsuarioFacturacionCalle(String usuarioFacturacionCalle) {
        this.usuarioFacturacionCalle = usuarioFacturacionCalle;
    }

    public String getUsuarioFacturacionCiudad() {
        return usuarioFacturacionCiudad;
    }

    public void setUsuarioFacturacionCiudad(String usuarioFacturacionCiudad) {
        this.usuarioFacturacionCiudad = usuarioFacturacionCiudad;
    }

    public String getUsuarioFacturacionProvincia() {
        return usuarioFacturacionProvincia;
    }

    public void setUsuarioFacturacionProvincia(String usuarioFacturacionProvincia) {
        this.usuarioFacturacionProvincia = usuarioFacturacionProvincia;
    }

    public String getUsuarioFacturacionPais() {
        return usuarioFacturacionPais;
    }

    public void setUsuarioFacturacionPais(String usuarioFacturacionPais) {
        this.usuarioFacturacionPais = usuarioFacturacionPais;
    }

    public String getUsuarioFacturacionCodigoPostal() {
        return usuarioFacturacionCodigoPostal;
    }

    public void setUsuarioFacturacionCodigoPostal(String usuarioFacturacionCodigoPostal) {
        this.usuarioFacturacionCodigoPostal = usuarioFacturacionCodigoPostal;
    }

    public UsuarioPago getUsuarioPago() {
        return usuarioPago;
    }

    public void setUsuarioPago(UsuarioPago usuarioPago) {
        this.usuarioPago = usuarioPago;
    }
}
