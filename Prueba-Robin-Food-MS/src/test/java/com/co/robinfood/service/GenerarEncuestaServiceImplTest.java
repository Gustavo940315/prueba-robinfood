package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.model.EncuestaEntity;
import com.co.robinfood.model.PreguntaEntity;
import com.co.robinfood.model.TipoPreguntaEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.repository.EncuestaRepository;
import com.co.robinfood.repository.ItemPreguntaRepository;
import com.co.robinfood.repository.PreguntaRepository;
import com.co.robinfood.service.Impl.CrearClienteServiceImpl;
import com.co.robinfood.service.Impl.GenerarEncuestaServiceImpl;

@RunWith(SpringRunner.class)
public class GenerarEncuestaServiceImplTest {

	@InjectMocks
	private GenerarEncuestaServiceImpl generarEncuestaService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private PreguntaRepository preguntaRepository;
	
	@Mock
	private ItemPreguntaRepository itemPreguntaRepository;
	
	@Mock
	private EncuestaRepository encuestaRepository;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test()
	public void encuestaSatisfactorioSegundaOpcionTest() throws MicroServiceException {
		ClienteEntity clienteEntity = new ClienteEntity();
		PreguntaEntity preguntaEntity = new PreguntaEntity();
		TipoPreguntaEntity tipoPregunta = new TipoPreguntaEntity();
		NuevaEncuestaDTO nuevaEncuesta = new NuevaEncuestaDTO();
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
		List<PreguntaEntity> list = Arrays.asList(preguntaEntity);
		pregunta.setTitulo("titulo");
		pregunta.setTipoPregunta("pregunta");
		pregunta.setPreguntaId(2l);
		List<PreguntaDTO> listPregunta = Arrays.asList(pregunta);
		nuevaEncuesta.setPreguntaDTO(listPregunta);
		
		EncuestaEntity responseRepository = new EncuestaEntity();
		responseRepository.setEncuestaId(1L);
		responseRepository.setCliente(clienteEntity);
		responseRepository.setFechaEncuesta(new Date());
		
		Mockito.when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
		Mockito.when(preguntaRepository.findAll()).thenReturn(list);
		Mockito.when(encuestaRepository.save(any(EncuestaEntity.class))).thenReturn(responseRepository);
		generarEncuestaService.generarEncuesta(1l);
		
		verify(clienteRepository, times(1));
	}
	
	@Test()
	public void generarEncuestaSatisfactorioTest() throws MicroServiceException {
		ClienteEntity clienteEntity = new ClienteEntity();
		PreguntaEntity preguntaEntity = new PreguntaEntity();
		TipoPreguntaEntity tipoPregunta = new TipoPreguntaEntity();
		NuevaEncuestaDTO nuevaEncuesta = new NuevaEncuestaDTO();
		PreguntaDTO pregunta = new PreguntaDTO();
		clienteEntity.setPrimerNombre("Juan");
		clienteEntity.setSegundoNombre("Luis");
		clienteEntity.setPrimerApellido("Aguilar");
		clienteEntity.setSegundoApellido("Aguilar");
		preguntaEntity.setPreguntaId(1L);
		tipoPregunta.setTipoPreguntaId(1L);
		tipoPregunta.setDetalleTipoPregunta("pregunta");
		preguntaEntity.setTipoPreguntaId(tipoPregunta);
		nuevaEncuesta.setEncuestaId(1);
		List<PreguntaEntity> list = Arrays.asList(preguntaEntity);
		pregunta.setTitulo("titulo");
		pregunta.setTipoPregunta("pregunta");
		pregunta.setPreguntaId(1l);
		List<PreguntaDTO> listPregunta = Arrays.asList(pregunta);
		nuevaEncuesta.setPreguntaDTO(listPregunta);
		
		EncuestaEntity responseRepository = new EncuestaEntity();
		responseRepository.setEncuestaId(1L);
		responseRepository.setCliente(clienteEntity);
		responseRepository.setFechaEncuesta(new Date());
		
		Mockito.when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
		Mockito.when(preguntaRepository.findAll()).thenReturn(list);
		Mockito.when(encuestaRepository.save(any(EncuestaEntity.class))).thenReturn(responseRepository);
		generarEncuestaService.generarEncuesta(1l);
		
		verify(clienteRepository, times(1));
	}

	
}
