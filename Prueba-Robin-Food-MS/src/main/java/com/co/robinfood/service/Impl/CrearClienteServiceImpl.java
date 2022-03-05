package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.CREAR_CLIENTES_SERVICE;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.METODO_CREAR_CLIENTES;
import static com.co.robinfood.utils.Constantes.STATUS_500;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_REGISTRO_CLIENTE;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.service.CrearClienteService;

@Service
public class CrearClienteServiceImpl implements CrearClienteService {

	private final ClienteRepository clienteRepository;

	public CrearClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public ClienteEntity crearCliente(ClienteEntity cliente) throws MicroServiceException {
		try {
			if (Objects.isNull(cliente)) {
				throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
			}
			ClienteEntity response = clienteRepository.save(cliente);
			if (Objects.nonNull(response)) {
				Optional<ClienteEntity> consultaRegistro = clienteRepository.findById(response.getClienteId());
				if (!consultaRegistro.isPresent()) {
					throw new MicroServiceException(STATUS_500,
							ERROR_REGISTRO_CLIENTE, null);
				}
			}
			return response;
		} catch (MicroServiceException e) {
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, CREAR_CLIENTES_SERVICE, METODO_CREAR_CLIENTES), e.getMensaje());
		}
	}

}
