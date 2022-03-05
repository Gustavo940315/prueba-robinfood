package com.co.robinfood.service;

import java.util.List;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;

public interface ConsultaClienteService  {

    public List<ClienteEntity> listaClientes() throws MicroServiceException;

}
