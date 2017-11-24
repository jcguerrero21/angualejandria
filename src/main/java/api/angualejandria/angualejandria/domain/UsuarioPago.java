package api.angualejandria.angualejandria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Juan Carlos on 23/11/2017.
 */

@Entity
public class UsuarioPago implements Serializable {

    private static final long serialVersionUID = 78091345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private int mesExpiracion;
    private int anioExpiracion;
    private int cvc;
    private String nombreTitular;
    private boolean pagoPredeterminado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "usuarioPago")
    private UsuarioFacturacion usuarioFacturacion;

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

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
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

    public boolean isPagoPredeterminado() {
        return pagoPredeterminado;
    }

    public void setPagoPredeterminado(boolean pagoPredeterminado) {
        this.pagoPredeterminado = pagoPredeterminado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacturacion getUsuarioFacturacion() {
        return usuarioFacturacion;
    }

    public void setUsuarioFacturacion(UsuarioFacturacion usuarioFacturacion) {
        this.usuarioFacturacion = usuarioFacturacion;
    }
}
