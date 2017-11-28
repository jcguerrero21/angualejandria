package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UsuarioEnvio implements Serializable{

    private static final long serialVersionUID = 498745987L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String usuarioEnvioNombre;
    private String usuarioEnvioCalle;
    private String usuarioEnvioCiudad;
    private String usuarioEnvioProvincia;
    private String usuarioEnvioPais;
    private String usuarioEnvioCodigoPostal;
    private Boolean usuarioEnvioPredeterminado;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioEnvioNombre() {
        return usuarioEnvioNombre;
    }

    public void setUsuarioEnvioNombre(String usuarioEnvioNombre) {
        this.usuarioEnvioNombre = usuarioEnvioNombre;
    }

    public String getUsuarioEnvioCalle() {
        return usuarioEnvioCalle;
    }

    public void setUsuarioEnvioCalle(String usuarioEnvioCalle) {
        this.usuarioEnvioCalle = usuarioEnvioCalle;
    }

    public String getUsuarioEnvioCiudad() {
        return usuarioEnvioCiudad;
    }

    public void setUsuarioEnvioCiudad(String usuarioEnvioCiudad) {
        this.usuarioEnvioCiudad = usuarioEnvioCiudad;
    }

    public String getUsuarioEnvioProvincia() {
        return usuarioEnvioProvincia;
    }

    public void setUsuarioEnvioProvincia(String usuarioEnvioProvincia) {
        this.usuarioEnvioProvincia = usuarioEnvioProvincia;
    }

    public String getUsuarioEnvioPais() {
        return usuarioEnvioPais;
    }

    public void setUsuarioEnvioPais(String usuarioEnvioPais) {
        this.usuarioEnvioPais = usuarioEnvioPais;
    }

    public String getUsuarioEnvioCodigoPostal() {
        return usuarioEnvioCodigoPostal;
    }

    public void setUsuarioEnvioCodigoPostal(String usuarioEnvioCodigoPostal) {
        this.usuarioEnvioCodigoPostal = usuarioEnvioCodigoPostal;
    }

    public Boolean getUsuarioEnvioPredeterminado() {
        return usuarioEnvioPredeterminado;
    }

    public void setUsuarioEnvioPredeterminado(Boolean usuarioEnvioPredeterminado) {
        this.usuarioEnvioPredeterminado = usuarioEnvioPredeterminado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
