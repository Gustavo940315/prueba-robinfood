package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.RespuestaPreguntaEntity;
import com.co.robinfood.repository.RespuestaPreguntaRepository;
import com.co.robinfood.service.Impl.ObtenerEncuestaServiceImpl;

@RunWith(SpringRunner.class)
public class ObtenerEncuestaImplTest {

	@InjectMocks
	private ObtenerEncuestaServiceImpl obtenerEncuestaService;
	
	@Mock
	private RespuestaPreguntaRepository respuestaPreguntaRepository;
	
	@Test
	public void obtenerEncuestaFailTest() throws MicroServiceException {
		RespuestaPreguntaEntity respuestaPregunta = new RespuestaPreguntaEntity();
		respuestaPregunta.setRespuestaXpreguntaId(1l);
		respuestaPregunta.setRespuesta("Respuesta");
		respuestaPregunta.setPregunta("pregunta");
		List<RespuestaPreguntaEntity> list = new ArrayList<RespuestaPreguntaEntity>();
		list.add(respuestaPregunta);
		Mockito.when(respuestaPreguntaRepository.findById(anyLong())).thenReturn(Optional.of(respuestaPregunta));

		obtenerEncuestaService.obtenerEncuesta(1l);
	}
}
