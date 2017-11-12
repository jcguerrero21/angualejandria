package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Libro;
import api.angualejandria.angualejandria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroResource {

    @Autowired
    private LibroService libroService;

    @RequestMapping (value="/libro/aņadir", method = RequestMethod.POST)
    public Libro aņadirLibroPost(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

}
