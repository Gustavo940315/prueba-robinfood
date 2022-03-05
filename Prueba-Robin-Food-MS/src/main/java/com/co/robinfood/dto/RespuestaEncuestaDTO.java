package com.co.robinfood.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaEncuestaDTO {

    private String titulo;
    private String respuesta;
	public RespuestaEncuestaDTO(String titulo, String respuesta) {
		super();
		this.titulo = titulo;
		this.respuesta = respuesta;
	}
    
    
}
