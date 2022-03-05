package com.co.robinfood.service;

import com.co.robinfood.dto.NuevaEncuestaDTO;
import com.co.robinfood.exception.MicroServiceException;

public interface GenerarEncuestaService {
	
	public NuevaEncuestaDTO generarEncuesta(long id) throws MicroServiceException;

}
