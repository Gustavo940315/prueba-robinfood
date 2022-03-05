package com.co.robinfood.service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;


public interface CrearClienteService {

	public ClienteEntity crearCliente(ClienteEntity cliente) throws MicroServiceException;
	
}
