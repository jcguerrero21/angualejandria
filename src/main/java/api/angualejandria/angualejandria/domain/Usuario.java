package api.angualejandria.angualejandria.domain;

import api.angualejandria.angualejandria.domain.security.Authority;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario implements UserDetails, Serializable{

    private static final long serialVersionUID = 902783495L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", nullable = false, updatable = false)
    private Long id;

    private String username;
    private String password;
    private String Nombre;
    private String Apellidos;

    private String email;
    private String telefono;
    private boolean activo = true;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioPago> usuarioPagoList;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioEnvio> usuarioEnvioList;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private CarritoCompra carritoCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public List<UsuarioPago> getUsuarioPagoList() {
        return usuarioPagoList;
    }

    public void setUsuarioPagoList(List<UsuarioPago> usuarioPagoList) {
        this.usuarioPagoList = usuarioPagoList;
    }

    public List<UsuarioEnvio> getUsuarioEnvioList() {
        return usuarioEnvioList;
    }

    public void setUsuarioEnvioList(List<UsuarioEnvio> usuarioEnvioList) {
        this.usuarioEnvioList = usuarioEnvioList;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();
        usuarioRoles.forEach(ur -> authorities.add(new Authority(ur.getRol().getNombre())));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }
}
