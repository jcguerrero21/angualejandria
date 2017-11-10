package api.angualejandria.angualejandria.repository;

import api.angualejandria.angualejandria.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Usuario, Long> {

    /**
	 * método para obtener el usuario por su username
	 *
	 * @param username
	 * @return
	 */
	Usuario findByUsername(String username);

    /**
	 * método para obtener el usuario por su email
	 *
	 * @param email
	 * @return
	 */
	Usuario findByEmail(String email);

    /**
	 * método para listar todos los uauarios
	 *
	 * @return
	 */
	List<Usuario> findAll();
}
