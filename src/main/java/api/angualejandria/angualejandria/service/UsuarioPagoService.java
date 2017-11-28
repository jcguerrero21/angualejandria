package api.angualejandria.angualejandria.service;

import api.angualejandria.angualejandria.domain.UsuarioPago;

/**
 * Created by Juan Carlos on 23/11/2017.
 */
public interface UsuarioPagoService {

    /**
     * m�todo para obtener el pago del usuario por su id
     *
     * @param id
     * @return
     */
    UsuarioPago getById(Long id);

    /**
     * m�todo para borrar el pago del usuario por su id
     *
     * @param id
     */
    void borrarById(Long id);
}
