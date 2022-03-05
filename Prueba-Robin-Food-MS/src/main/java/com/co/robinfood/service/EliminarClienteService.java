package com.co.robinfood.service;

import com.co.robinfood.exception.MicroServiceException;

public interface EliminarClienteService {

	public void eliminarCliente(long id)  throws MicroServiceException;
}
