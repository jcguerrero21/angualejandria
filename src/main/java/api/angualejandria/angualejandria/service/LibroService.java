package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.Libro;

import java.util.List;

public interface LibroService {

    /**
     * método para listar todos los libros
     *
     * @return
     */
    List<Libro> getAll();


    /**
     * método para obtener un libro por su id
     *
     * @param id
     * @return
     */
    Libro getUno (Long id);

    /**
     * método para guardar el libro
     *
     * @param libro
     * @return
     */
    Libro guardar(Libro libro);

    /**
     * méotodo para buscar un libro por su titulo
     *
     * @param palabraClave
     * @return
     */
    List<Libro> busquedaBorrosa(String palabraClave);

    /**
     * método para borrar un libro
     *
     * @param id
     */
    void deleteUno(Long id);

}
