package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.Libro;

import java.util.List;

public interface LibroService {

    /**
     * m�todo para listar todos los libros
     *
     * @return
     */
    List<Libro> getAll();


    /**
     * m�todo para obtener un libro por su id
     *
     * @param id
     * @return
     */
    Libro getUno (Long id);

    /**
     * m�todo para guardar el libro
     *
     * @param libro
     * @return
     */
    Libro guardar(Libro libro);

    /**
     * m�otodo para buscar un libro por su titulo
     *
     * @param palabraClave
     * @return
     */
    List<Libro> busquedaBorrosa(String palabraClave);

    /**
     * m�todo para borrar un libro
     *
     * @param id
     */
    void deleteUno(Long id);

}
