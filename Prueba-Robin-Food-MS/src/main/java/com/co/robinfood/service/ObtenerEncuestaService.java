package com.co.robinfood.service;

import com.co.robinfood.dto.EncuestaDTO;
import com.co.robinfood.exception.MicroServiceException;

public interface ObtenerEncuestaService {
	
	public EncuestaDTO obtenerEncuesta(long encuestaId) throws MicroServiceException;

}
