package com.co.robinfood.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.co.robinfood.utils.Constantes.CLIENTE_ENDPOINT;
import static com.co.robinfood.utils.Constantes.CREAR_CLIENTE;
import static com.co.robinfood.utils.Constantes.ACTUALIZAR_CLIENTE;
import static com.co.robinfood.utils.Constantes.ELIMINAR_CLIENTE;
import static com.co.robinfood.utils.Constantes.STATUS_200;
import static com.co.robinfood.utils.Constantes.MENSAJE_SATISFACTORIO;
import static com.co.robinfood.utils.Constantes.ELIMINAR_CLIENTE_SATISFACTORIA;

import java.util.List;

import com.co.robinfood.dto.ResultadoDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.service.ConsultaClienteService;
import com.co.robinfood.service.CrearClienteService;
import com.co.robinfood.service.EliminarClienteService;
import com.co.robinfood.service.ModificarClienteService;

@RestController
@RequestMapping(CLIENTE_ENDPOINT)
public class ClientController {

	private final ConsultaClienteService consultaClienteService;
	private final CrearClienteService crearClienteService; 
	private final ModificarClienteService modificarClienteService;
	private final EliminarClienteService eliminarClienteService; 

	public ClientController(ConsultaClienteService consultaClienteService, CrearClienteService crearClienteService,
			ModificarClienteService modificarClienteService, EliminarClienteService eliminarClienteService) {
		super();
		this.consultaClienteService = consultaClienteService;
		this.crearClienteService = crearClienteService;
		this.modificarClienteService = modificarClienteService;
		this.eliminarClienteService = eliminarClienteService;
	}

	@GetMapping
	public ResultadoDTO listadoEncuesta() {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			List<ClienteEntity> response = consultaClienteService.listaClientes();
			resultadoDTO.setDetalle(response);
			resultadoDTO.setStatus(STATUS_200);
			resultadoDTO.setMensaje(MENSAJE_SATISFACTORIO);
			return resultadoDTO;	
		} catch (MicroServiceException e) {
			resultadoDTO.setStatus(e.getStatus());
			resultadoDTO.setDetalle(e.getMensaje());
			resultadoDTO.setMensaje(e.getDetalle());
		}
		return resultadoDTO;
	}
	
	@PostMapping(CREAR_CLIENTE)
	public ResultadoDTO CrearCliente(@RequestBody ClienteEntity request)  {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			ClienteEntity response = crearClienteService.crearCliente(request);
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
	
	@PutMapping(ACTUALIZAR_CLIENTE)
	public ResultadoDTO modificarCliente(@PathVariable long id, @RequestBody ClienteEntity request) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			ClienteEntity response = modificarClienteService.modificarCliente(id, request);
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
	
	@DeleteMapping(ELIMINAR_CLIENTE)
	public ResultadoDTO eliminarCliente(@PathVariable long id) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			this.eliminarClienteService.eliminarCliente(id);
			resultadoDTO.setDetalle(ELIMINAR_CLIENTE_SATISFACTORIA);
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
