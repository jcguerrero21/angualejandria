package api.angualejandria.angualejandria;

import api.angualejandria.angualejandria.config.SecurityUtility;
import api.angualejandria.angualejandria.domain.Usuario;
import api.angualejandria.angualejandria.domain.security.Rol;
import api.angualejandria.angualejandria.domain.security.UsuarioRol;
import api.angualejandria.angualejandria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AngualejandriaApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AngualejandriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Set<UsuarioRol> usuarioRoles = new HashSet<>();

		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Juan Carlos");
		usuario1.setApellidos("Guerrero Moyano");
		usuario1.setUsername("jc");
		usuario1.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
		usuario1.setEmail("jotace@gmail.com");
		Rol rol1 = new Rol();
		rol1.setRolId(1);
		rol1.setNombre("ROL_USUARIO");
		usuarioRoles.add(new UsuarioRol(usuario1, rol1));

		userService.crearUsuario(usuario1, usuarioRoles);

		usuarioRoles.clear();

		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Admin");
		usuario2.setApellidos("Admin");
		usuario2.setUsername("Admin");
		usuario2.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		usuario2.setEmail("Admin@gmail.com");
		Rol rol2 = new Rol();
		rol2.setRolId(0);
		rol2.setNombre("ROL_ADMIN");
		usuarioRoles.add(new UsuarioRol(usuario2, rol2));

		userService.crearUsuario(usuario2, usuarioRoles);

		usuarioRoles.clear();
	}
}
