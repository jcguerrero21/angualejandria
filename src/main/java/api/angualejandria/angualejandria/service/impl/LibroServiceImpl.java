package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.Libro;
import api.angualejandria.angualejandria.repository.LibroRepository;
import api.angualejandria.angualejandria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRespository;

    public List<Libro> getAll() {
        List<Libro> listaLibros = (List<Libro>) libroRespository.findAll();

        List<Libro> listaLibrosActiva = new ArrayList<>();

        for (Libro libro: listaLibros){
            if(libro.isActivo()) {
                listaLibrosActiva.add(libro);
            }
        }

        return listaLibrosActiva;
    }

    public Libro getUno(Long id) {
        return libroRespository.findOne(id);
    }

    public Libro guardar(Libro libro){
        return libroRespository.save(libro);
    }

    public List<Libro> busquedaBorrosa(String palabraClave) {
        List<Libro> listaLibros = libroRespository.findByTituloContaining(palabraClave);

        List<Libro> listaLibrosActiva = new ArrayList<>();

        for (Libro libro: listaLibros){
            if(libro.isActivo()) {
                listaLibrosActiva.add(libro);
            }
        }

        return listaLibrosActiva;
    }

    public void deleteUno(Long id){
        libroRespository.delete(id);
    }

}
