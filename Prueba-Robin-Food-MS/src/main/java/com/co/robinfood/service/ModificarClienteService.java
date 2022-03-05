package com.co.robinfood.service;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;

public interface ModificarClienteService {

    public ClienteEntity modificarCliente(long id , ClienteEntity cliente) throws MicroServiceException;

}
