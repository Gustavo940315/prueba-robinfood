package com.co.robinfood.service;

import java.util.List;

import com.co.robinfood.dto.RespuestaDTO;
import com.co.robinfood.exception.MicroServiceException;


public interface GuardarEncuestaService {

	public void guardarEncuesta(long id, List<RespuestaDTO> request) throws MicroServiceException;
}
