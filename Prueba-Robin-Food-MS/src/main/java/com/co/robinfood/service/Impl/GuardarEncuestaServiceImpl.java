package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_NO_EXISTE_ENCUESTA;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.METODO_GUARDAR_ENCUESTA;
import static com.co.robinfood.utils.Constantes.GUARDAR_ENCUESTA_SERVICE;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.STATUS_500;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.robinfood.dto.RespuestaDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.EncuestaEntity;
import com.co.robinfood.model.PreguntaEntity;
import com.co.robinfood.model.RespuestaPreguntaEntity;
import com.co.robinfood.repository.EncuestaRepository;
import com.co.robinfood.repository.PreguntaRepository;
import com.co.robinfood.repository.RespuestaPreguntaRepository;
import com.co.robinfood.service.GuardarEncuestaService;

@Service
public class GuardarEncuestaServiceImpl implements GuardarEncuestaService {

	private final EncuestaRepository encuestaRepository;
	private final PreguntaRepository preguntaRepository;
	private final RespuestaPreguntaRepository respuestaPreguntaRepository;
	
	public GuardarEncuestaServiceImpl(EncuestaRepository encuestaRepository, PreguntaRepository preguntaRepository, RespuestaPreguntaRepository respuestaPreguntaRepository) {
		this.encuestaRepository = encuestaRepository;
		this.preguntaRepository = preguntaRepository;
		this.respuestaPreguntaRepository = respuestaPreguntaRepository;
	}

	@Override
	public void guardarEncuesta(long id, List<RespuestaDTO> request) throws MicroServiceException {
        try{
        	List<RespuestaPreguntaEntity> listRespuestaPregunta = new ArrayList<>();
            RespuestaPreguntaEntity respuestaPreguntaEntity= new RespuestaPreguntaEntity();
            if(Objects.isNull(id) || Objects.isNull(request)) {
            	throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
            }
            Optional<EncuestaEntity> encuestaEntity = encuestaRepository.findById(id);
            if(encuestaEntity.isPresent()){
                for (RespuestaDTO respuesta : request) {
                    respuestaPreguntaEntity= new RespuestaPreguntaEntity();
                    respuestaPreguntaEntity.setEncuestaEntity(encuestaEntity.get());
                    Optional<PreguntaEntity> pregunta  = preguntaRepository.findById(respuesta.getPreguntaId());
                    if(pregunta.isPresent()) {
                        respuestaPreguntaEntity.setPreguntaEntity(pregunta.get());
                        respuestaPreguntaEntity.setPregunta(pregunta.get().getTitulo());
                        respuestaPreguntaEntity.setRespuesta(respuesta.getRespuesta());
                    }
                    listRespuestaPregunta.add(respuestaPreguntaEntity);
                }

                respuestaPreguntaRepository.saveAll(listRespuestaPregunta);

            }else{
            	throw new MicroServiceException(STATUS_500,
            			ERROR_NO_EXISTE_ENCUESTA, null);
            }
        }catch (MicroServiceException e){
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, GUARDAR_ENCUESTA_SERVICE, METODO_GUARDAR_ENCUESTA), e.getMensaje());
        }
		
	}

}
