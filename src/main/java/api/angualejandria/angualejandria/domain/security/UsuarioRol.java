package api.angualejandria.angualejandria.domain.security;

import api.angualejandria.angualejandria.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable{
    private static final long serialVersionUID = 890345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long usuarioRolId;

    public UsuarioRol(){}

    public UsuarioRol(Usuario usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rol;

    public long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
