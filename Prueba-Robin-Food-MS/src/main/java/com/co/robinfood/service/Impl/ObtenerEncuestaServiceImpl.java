package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_NO_EXISTE_ENCUESTA;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.METODO_OBTENER_ENCUESTA;
import static com.co.robinfood.utils.Constantes.OBTENER_ENCUESTA_SERVICE;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.STATUS_500;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.co.robinfood.dto.EncuestaDTO;
import com.co.robinfood.dto.RespuestaEncuestaDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.EncuestaEntity;
import com.co.robinfood.model.RespuestaPreguntaEntity;
import com.co.robinfood.repository.RespuestaPreguntaRepository;
import com.co.robinfood.service.ObtenerEncuestaService;

@Service
public class ObtenerEncuestaServiceImpl implements ObtenerEncuestaService {

	private final RespuestaPreguntaRepository respuestaPreguntaRepository;
		
	public ObtenerEncuestaServiceImpl(RespuestaPreguntaRepository respuestaPreguntaRepository) {
		this.respuestaPreguntaRepository = respuestaPreguntaRepository;
	}

	@Override
	public EncuestaDTO obtenerEncuesta(long id) throws MicroServiceException {
        try{
            EncuestaDTO encuesta = new EncuestaDTO();
            EncuestaEntity encuestaEntity = new EncuestaEntity();
            List<RespuestaEncuestaDTO> listaRespuestas = new ArrayList<RespuestaEncuestaDTO>();
            if(Objects.isNull(id)) {
            	throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
            }
            List<RespuestaPreguntaEntity> respuestaPreguntaEntity = respuestaPreguntaRepository.findByEncuestaId(id);
            if(!respuestaPreguntaEntity.isEmpty() && Objects.nonNull(respuestaPreguntaEntity)){
                encuestaEntity = respuestaPreguntaEntity.get(0).getEncuestaEntity();
                encuesta.setCliente(encuestaEntity.getCliente().getPrimerNombre().concat(" ")
                					.concat( encuestaEntity.getCliente().getSegundoNombre()).concat(" ")
                					.concat(encuestaEntity.getCliente().getPrimerApellido()).concat(" ")
                					.concat(encuestaEntity.getCliente().getSegundoApellido()).concat(" "));
                listaRespuestas = respuestaPreguntaEntity.stream()
                        .map( p-> new  RespuestaEncuestaDTO(p.getPregunta(),p.getRespuesta()))
                        .collect(Collectors.toList());
                encuesta.setListaRespuestas(listaRespuestas);
                return  encuesta;

            }else{
            	throw new MicroServiceException(STATUS_500,
            			ERROR_NO_EXISTE_ENCUESTA, null);
            }
        }catch (MicroServiceException e){
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, OBTENER_ENCUESTA_SERVICE, METODO_OBTENER_ENCUESTA), e.getMensaje());
        }
	}

}
