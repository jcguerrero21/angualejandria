package api.angualejandria.angualejandria.service.impl;

import api.angualejandria.angualejandria.domain.UsuarioEnvio;
import api.angualejandria.angualejandria.repository.UsuarioEnvioRepository;
import api.angualejandria.angualejandria.service.UsuarioEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEnvioServiceImpl implements UsuarioEnvioService{

    @Autowired
    private UsuarioEnvioRepository usuarioEnvioRepository;

    public UsuarioEnvio getById(Long id) {
        return usuarioEnvioRepository.findOne(id);
    }

    public void borrarById(Long id) {
        usuarioEnvioRepository.delete(id);
    }
}
