package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.UsuarioPago;
import api.angualejandria.angualejandria.repository.UsuarioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juan Carlos on 23/11/2017.
 */

@Service
public class UsuarioPagoServiceImpl {

    @Autowired
    private UsuarioPagoRepository usuarioPagoRepository;

    public UsuarioPago getById(Long id) {
        return usuarioPagoRepository.findOne(id);
    }

    public void borrarById(Long id) {
        usuarioPagoRepository.delete(id);
    }
}
