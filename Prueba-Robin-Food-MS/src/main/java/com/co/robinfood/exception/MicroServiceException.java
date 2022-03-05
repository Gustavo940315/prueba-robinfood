package com.co.robinfood.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@SuppressWarnings("serial")
public class MicroServiceException extends Exception {
	
	private String status;
	private String mensaje;
	private String detalle;
	public MicroServiceException(String status, String mensaje, String detalle) {
		this.status = status;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}
	
	
}