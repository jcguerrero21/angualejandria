package api.angualejandria.angualejandria.resource;

import api.angualejandria.angualejandria.domain.Libro;
import api.angualejandria.angualejandria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroResource {

    @Autowired
    private LibroService libroService;

    @RequestMapping(value = "/aniadir", method = RequestMethod.POST)
    public Libro añadirLibroPost(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @RequestMapping(value = "/aniadir/image", method = RequestMethod.POST)
    public ResponseEntity subirImagenPortadoLibro(
            @RequestParam("id") Long id,
            HttpServletResponse response, HttpServletRequest request
    ) {
        try {
            Libro libro = libroService.getUno(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id + ".png";


            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/libro/" + fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/listaLibros")
    public List<Libro> getListaLibros() {
        return libroService.getAll();
    }

    @RequestMapping("/{id}")
    public Libro getLibro(@PathVariable("id") Long id){
        Libro libro = libroService.getUno(id);
        return libro;
    }

    @RequestMapping(value="/actualizar", method=RequestMethod.POST)
    public Libro actualizarLibroPost(@RequestBody Libro libro){
        return libroService.guardar(libro);
    }

    @RequestMapping(value = "/actualizar/image", method = RequestMethod.POST)
    public ResponseEntity actualizarImagenPortadoLibro(
            @RequestParam("id") Long id,
            HttpServletResponse response, HttpServletRequest request
    ) {
        try {
            Libro libro = libroService.getUno(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id + ".png";

            Files.delete(Paths.get("src/main/resources/static/image/libro/"+fileName));

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/libro/" + fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/borrar", method = RequestMethod.POST)
    public ResponseEntity borrar(@RequestBody String id) throws IOException{
        libroService.deleteUno(Long.parseLong(id));
        String fileName = id + ".png";

        Files.delete(Paths.get("src/main/resources/static/image/libro/"+fileName));
        return new ResponseEntity("Borrado correctamente", HttpStatus.OK);
    }
}
