package api.angualejandria.angualejandria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Libro implements Serializable{

    private static final long serialVersionUID=425345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private String editorial;
    private String fechaDePublicacion;
    private String idioma;
    private String categoria;
    private int numeroDePaginas;
    private String formato;
    private String isbn;
    private double pesoDelEnvio;
    private double listaDePrecios;
    private double nuestroPrecio;
    private boolean activo=true;

    @Column(columnDefinition="text")
    private String descripcion;
    private int numeroDeStock;

    @Transient
    private MultipartFile imagenLibro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPesoDelEnvio() {
        return pesoDelEnvio;
    }

    public void setPesoDelEnvio(double pesoDelEnvio) {
        this.pesoDelEnvio = pesoDelEnvio;
    }

    public double getListaDePrecios() {
        return listaDePrecios;
    }

    public void setListaDePrecios(double listaDePrecios) {
        this.listaDePrecios = listaDePrecios;
    }

    public double getNuestroPrecio() {
        return nuestroPrecio;
    }

    public void setNuestroPrecio(double nuestroPrecio) {
        this.nuestroPrecio = nuestroPrecio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroDeStock() {
        return numeroDeStock;
    }

    public void setNumeroDeStock(int numeroDeStock) {
        this.numeroDeStock = numeroDeStock;
    }

    public MultipartFile getImagenLibro() {
        return imagenLibro;
    }

    public void setImagenLibro(MultipartFile imagenLibro) {
        this.imagenLibro = imagenLibro;
    }
}
