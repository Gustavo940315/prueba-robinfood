package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_CLIENTE_NO_EXISTE;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.ELIMINAR_CLIENTES_SERVICE;
import static com.co.robinfood.utils.Constantes.METODO_ELIMINAR_CLIENTES;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.STATUS_500;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.service.EliminarClienteService;

@Service
public class EliminarClienteServiceImpl implements EliminarClienteService {

	private final ClienteRepository clienteRepository;
	
	public EliminarClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public void eliminarCliente(long id) throws MicroServiceException {
		try {
			if (Objects.isNull(id)) {
				throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
			}
			Optional<ClienteEntity> response = clienteRepository.findById(id);
			if (response.isPresent()) {
				clienteRepository.deleteById(response.get().getClienteId());
			}else {
				throw new MicroServiceException(STATUS_500,
						ERROR_CLIENTE_NO_EXISTE, null);
			}
		} catch (MicroServiceException e) {
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, ELIMINAR_CLIENTES_SERVICE, METODO_ELIMINAR_CLIENTES), e.getMensaje());
		}
	}

}
