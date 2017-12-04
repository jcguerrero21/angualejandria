package api.angualejandria.angualejandria.repository;

import api.angualejandria.angualejandria.domain.Factura;
import api.angualejandria.angualejandria.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
    List<Factura> findByUsuario(Usuario usuario);
}
