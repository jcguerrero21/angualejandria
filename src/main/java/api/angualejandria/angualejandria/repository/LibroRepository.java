package api.angualejandria.angualejandria.repository;

import api.angualejandria.angualejandria.domain.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibroRepository extends CrudRepository<Libro, Long>{

    //es muy importante que utilicemos siempre el nombre una de nuestras clases m�s la entidad propia de Spring CrudRepository
    // ejemplo: tenemos que usar Titulo + Containing y no titulo + Contenido porque si no funcionar�

    List<Libro> findByTituloContaining(String palabraClave);

}
