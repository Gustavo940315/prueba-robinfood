package com.co.robinfood.service.Impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.service.ConsultaClienteService;

import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.METODO_LISTAR_CLIENTES;
import static com.co.robinfood.utils.Constantes.CONSULTAR_CLIENTES_SERVICE;
import static com.co.robinfood.utils.Constantes.STATUS_500;;

@Service
public class ClienteServiceImpl implements ConsultaClienteService {
	
	private final ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<ClienteEntity> listaClientes() throws MicroServiceException {
		try {
            List<ClienteEntity> listCliente =  (List<ClienteEntity>) clienteRepository.findAll();
            if(Objects.isNull(listCliente)) {
    			throw new MicroServiceException( STATUS_500 ,String.format(FORMATO_ERROR, CONSULTAR_CLIENTES_SERVICE, METODO_LISTAR_CLIENTES), null);
            }
        	return listCliente;
		} catch (MicroServiceException e) {
			throw new MicroServiceException(STATUS_500, String.format(FORMATO_ERROR, CONSULTAR_CLIENTES_SERVICE, METODO_LISTAR_CLIENTES), e.getDetalle());
		}
	}

}
