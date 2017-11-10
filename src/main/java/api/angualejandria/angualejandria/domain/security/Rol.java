package api.angualejandria.angualejandria.domain.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;

@Entity
public class Rol implements Serializable {

    private static final long serialVersionUID = 890245234L;

    @Id
    private int rolId;

    private String nombre;

    private Set<UsuarioRoe> usuarioRoles = new HashSet<>();

    public Rol(){}

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRole> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRole> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}
