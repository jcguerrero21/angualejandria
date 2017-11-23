package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.UsuarioPago;

/**
 * Created by Juan Carlos on 23/11/2017.
 */
public interface UsuarioPagoService {

    UsuarioPago getById(Long id);

    void borrarById(Long id);
}
