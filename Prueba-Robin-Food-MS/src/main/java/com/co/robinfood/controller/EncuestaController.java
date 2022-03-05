package com.co.robinfood.controller;

import static com.co.robinfood.utils.Constantes.CONSULTAR_ENCUESTA;
import static com.co.robinfood.utils.Constantes.ENCUESTA_ENDPOINT;
import static com.co.robinfood.utils.Constantes.GUARDAR_ENCUESTA;
import static com.co.robinfood.utils.Constantes.GUARDAR_PREGUNTAS_ENCUESTA;
import static com.co.robinfood.utils.Constantes.MENSAJE_SATISFACTORIO;
import static com.co.robinfood.utils.Constantes.STATUS_200;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.robinfood.dto.EncuestaDTO;
import com.co.robinfood.dto.NuevaEncuestaDTO;
import com.co.robinfood.dto.RespuestaDTO;
import com.co.robinfood.dto.ResultadoDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.service.GenerarEncuestaService;
import com.co.robinfood.service.GuardarEncuestaService;
import com.co.robinfood.service.ObtenerEncuestaService;

@RestController
@RequestMapping(ENCUESTA_ENDPOINT)
public class EncuestaController {

	private final GenerarEncuestaService generarEncuestaService;
	private final GuardarEncuestaService guardarEncuestaService;
	private final ObtenerEncuestaService obtenerEncuestaService;
	
	public EncuestaController(GenerarEncuestaService generarEncuestaService,
			GuardarEncuestaService guardarEncuestaService, ObtenerEncuestaService obtenerEncuestaService) {
		this.generarEncuestaService = generarEncuestaService;
		this.guardarEncuestaService = guardarEncuestaService;
		this.obtenerEncuestaService = obtenerEncuestaService;
	}


	@GetMapping(CONSULTAR_ENCUESTA)
	public ResultadoDTO consultaEncuesta(@PathVariable long id) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			EncuestaDTO response = obtenerEncuestaService.obtenerEncuesta(id);
			resultadoDTO.setDetalle(response);
			resultadoDTO.setStatus(STATUS_200);
			resultadoDTO.setMensaje(MENSAJE_SATISFACTORIO);
			return resultadoDTO;	
		} catch (MicroServiceException e) {
			resultadoDTO.setStatus(e.getStatus());
			resultadoDTO.setDetalle(e.getDetalle());
			resultadoDTO.setMensaje(e.getMensaje());
		}
		return resultadoDTO;
	}
	
	
	@PostMapping(GUARDAR_PREGUNTAS_ENCUESTA)
	public ResultadoDTO guardarPreguntas(@PathVariable long id) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			NuevaEncuestaDTO response = generarEncuestaService.generarEncuesta(id);
			resultadoDTO.setDetalle(response);
			resultadoDTO.setStatus(STATUS_200);
			resultadoDTO.setMensaje(MENSAJE_SATISFACTORIO);
			return resultadoDTO;	
		} catch (MicroServiceException e) {
			resultadoDTO.setStatus(e.getStatus());
			resultadoDTO.setDetalle(e.getDetalle());
			resultadoDTO.setMensaje(e.getMensaje());
		}
		return resultadoDTO;
	}
	
	@PostMapping(GUARDAR_ENCUESTA)
	public ResultadoDTO guardarEncuesta(@PathVariable long id, @RequestBody List<RespuestaDTO> request) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			guardarEncuestaService.guardarEncuesta(id, request);
			resultadoDTO.setStatus(STATUS_200);
			resultadoDTO.setMensaje(MENSAJE_SATISFACTORIO);
			return resultadoDTO;	
		} catch (MicroServiceException e) {
			resultadoDTO.setStatus(e.getStatus());
			resultadoDTO.setDetalle(e.getDetalle());
			resultadoDTO.setMensaje(e.getMensaje());
		}
		return resultadoDTO;
	}

}
