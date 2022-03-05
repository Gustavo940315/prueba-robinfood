package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.robinfood.dto.NuevaEncuestaDTO;
import com.co.robinfood.dto.PreguntaDTO;
import com.co.robinfood.dto.RespuestaDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.model.EncuestaEntity;
import com.co.robinfood.model.PreguntaEntity;
import com.co.robinfood.model.TipoPreguntaEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.repository.EncuestaRepository;
import com.co.robinfood.repository.PreguntaRepository;
import com.co.robinfood.repository.RespuestaPreguntaRepository;
import com.co.robinfood.service.Impl.GuardarEncuestaServiceImpl;

@RunWith(SpringRunner.class)
public class GuardarEncuestaServiceImplTest {

	@InjectMocks
	private GuardarEncuestaServiceImpl guardarEncuestaService;
	
	@Mock
	private EncuestaRepository encuestaRepository;
	
	@Mock
	private PreguntaRepository preguntaRepository;
	
	@Mock
	private RespuestaPreguntaRepository respuestaPreguntaRepository;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test()
	public void guardarEncuestaFailTest() throws MicroServiceException {
		exceptionRule.expect(MicroServiceException.class);
		guardarEncuestaService.guardarEncuesta(1l, null);
	}
	
	@Test()
	public void guardarEncuestaSatisfactorioTest() throws MicroServiceException {
		ClienteEntity clienteEntity = new ClienteEntity();
		PreguntaEntity preguntaEntity = new PreguntaEntity();
		TipoPreguntaEntity tipoPregunta = new TipoPreguntaEntity();
		NuevaEncuestaDTO nuevaEncuesta = new NuevaEncuestaDTO();
		List<RespuestaDTO> request = new ArrayList<RespuestaDTO>();
		RespuestaDTO respuesta = new RespuestaDTO();
		respuesta.setPreguntaId(1l);
		respuesta.setRespuesta("response");
		request.add(respuesta);
		PreguntaDTO pregunta = new PreguntaDTO();
		clienteEntity.setPrimerNombre("Juan");
		clienteEntity.setSegundoNombre("Luis");
		clienteEntity.setPrimerApellido("Aguilar");
		clienteEntity.setSegundoApellido("Aguilar");
		preguntaEntity.setPreguntaId(2L);
		tipoPregunta.setTipoPreguntaId(2L);
		tipoPregunta.setDetalleTipoPregunta("pregunta");
		preguntaEntity.setTipoPreguntaId(tipoPregunta);
		nuevaEncuesta.setEncuestaId(2l);
		pregunta.setTitulo("titulo");
		pregunta.setTipoPregunta("pregunta");
		pregunta.setPreguntaId(2l);
		List<PreguntaDTO> listPregunta = Arrays.asList(pregunta);
		nuevaEncuesta.setPreguntaDTO(listPregunta);
		
		EncuestaEntity responseRepository = new EncuestaEntity();
		responseRepository.setEncuestaId(1L);
		responseRepository.setCliente(clienteEntity);
		responseRepository.setFechaEncuesta(new Date());
		
		Mockito.when(preguntaRepository.findById(anyLong())).thenReturn(Optional.of(preguntaEntity));
		Mockito.when(encuestaRepository.findById(anyLong())).thenReturn(Optional.of(responseRepository));
		respuestaPreguntaRepository.saveAll(null);
		guardarEncuestaService.guardarEncuesta(1l, request);
		
		verify(preguntaRepository, times(1));
	}
}
