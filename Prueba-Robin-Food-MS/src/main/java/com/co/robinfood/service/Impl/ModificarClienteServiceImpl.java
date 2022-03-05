package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_CLIENTE_NO_EXISTE;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.STATUS_500;
import static com.co.robinfood.utils.Constantes.MODIFICAR_CLIENTES_SERVICE;
import static com.co.robinfood.utils.Constantes.METODO_MODIFICAR_CLIENTES;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.service.ModificarClienteService;

@Service
public class ModificarClienteServiceImpl implements ModificarClienteService {

	private final ClienteRepository clienteRepository;

	public ModificarClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public ClienteEntity modificarCliente(long id, ClienteEntity cliente) throws MicroServiceException {
		try {
			ClienteEntity clienteModificado = new ClienteEntity();
			if (Objects.isNull(cliente) || Objects.isNull(id)) {
				throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
			}
			Optional<ClienteEntity> response = clienteRepository.findById(id);
			if (response.isPresent()) {
				response.get().setCelular(cliente.getCelular());
				response.get().setPrimerNombre(cliente.getPrimerNombre());
				response.get().setSegundoNombre(cliente.getSegundoNombre());
				response.get().setPrimerApellido(cliente.getPrimerApellido());
				response.get().setSegundoApellido(cliente.getSegundoApellido());
                clienteModificado=clienteRepository.save(response.get());
			}else {
				throw new MicroServiceException(STATUS_500,
						ERROR_CLIENTE_NO_EXISTE, null);
			}
			return clienteModificado;
		} catch (MicroServiceException e) {
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, MODIFICAR_CLIENTES_SERVICE, METODO_MODIFICAR_CLIENTES), e.getMensaje());
		}
	
	}
	
}
