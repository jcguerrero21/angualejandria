package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.UsuarioEnvio;

public interface UsuarioEnvioService {

    /**
     * método para obtener el envio del usuario por id
     *
     * @param id
     * @return
     */
    UsuarioEnvio getById(Long id);

    /**
     *
     *
     * @param id
     */
    void borrarById(Long id);

}
