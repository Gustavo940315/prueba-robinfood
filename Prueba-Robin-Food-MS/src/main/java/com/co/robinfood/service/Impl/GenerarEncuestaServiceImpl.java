package com.co.robinfood.service.Impl;

import static com.co.robinfood.utils.Constantes.BAD_REQUEST;
import static com.co.robinfood.utils.Constantes.ERROR_CLIENTE_NO_EXISTE;
import static com.co.robinfood.utils.Constantes.FORMATO_ERROR;
import static com.co.robinfood.utils.Constantes.METODO_GENERAR_ENCUESTA;
import static com.co.robinfood.utils.Constantes.GENERAR_ENCUESTA_SERVICE;
import static com.co.robinfood.utils.Constantes.STATUS_400;
import static com.co.robinfood.utils.Constantes.STATUS_500;
import static com.co.robinfood.utils.Constantes.TIPO_PREGUNTA_S_N;
import static com.co.robinfood.utils.Constantes.TIPO_PREGUNTA_TEXTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.robinfood.dto.NuevaEncuestaDTO;
import com.co.robinfood.dto.PreguntaDTO;
import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.model.EncuestaEntity;
import com.co.robinfood.model.ItemsPreguntaEntity;
import com.co.robinfood.model.PreguntaEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.repository.EncuestaRepository;
import com.co.robinfood.repository.ItemPreguntaRepository;
import com.co.robinfood.repository.PreguntaRepository;
import com.co.robinfood.service.GenerarEncuestaService;

@Service
public class GenerarEncuestaServiceImpl implements GenerarEncuestaService {

	private final ClienteRepository clienteRepository;
	private final PreguntaRepository preguntaRepository;
	private final ItemPreguntaRepository itemPreguntaRepository;
	private final EncuestaRepository encuestaRepository;
	
	public GenerarEncuestaServiceImpl(ClienteRepository clienteRepository, PreguntaRepository preguntaRepository,
			ItemPreguntaRepository itemPreguntaRepository, EncuestaRepository encuestaRepository) {
		this.clienteRepository = clienteRepository;
		this.preguntaRepository = preguntaRepository;
		this.itemPreguntaRepository = itemPreguntaRepository;
		this.encuestaRepository = encuestaRepository;
	}

	@Override
	public NuevaEncuestaDTO generarEncuesta(long id) throws MicroServiceException {
		try {
            List <PreguntaDTO> encuesta = new ArrayList<>();
            PreguntaDTO preguntaDTO = new PreguntaDTO();
            List<String> listaOpciones = new ArrayList<>();
            EncuestaEntity encuestaEntity = new EncuestaEntity();
            EncuestaEntity nuevaEncuesta = new EncuestaEntity();
            NuevaEncuestaDTO encuestaNuevaDTO = new NuevaEncuestaDTO();
            int contador;
            if(Objects.isNull(id)) {
            	throw new MicroServiceException(STATUS_400,
						BAD_REQUEST, null);
            }
            Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
            if(clienteEntity.isPresent()){
            	List<PreguntaEntity> listaPreguntas = (List<PreguntaEntity>) preguntaRepository.findAll();
                for (PreguntaEntity pregunta:listaPreguntas) {
                    preguntaDTO = new PreguntaDTO();
                    listaOpciones = new ArrayList<>();
                    contador=1;
                    preguntaDTO.setTitulo(pregunta.getTitulo());
                    preguntaDTO.setPreguntaId(pregunta.getPreguntaId());
                    if(TIPO_PREGUNTA_TEXTO == pregunta.getTipoPreguntaId().getTipoPreguntaId()){
                        preguntaDTO.setTipoPregunta(pregunta.getTipoPreguntaId().getDetalleTipoPregunta());
                        preguntaDTO.setCodigoTipoPregunta(pregunta.getTipoPreguntaId().getTipoPreguntaId());
                    }else if (TIPO_PREGUNTA_S_N  == pregunta.getTipoPreguntaId().getTipoPreguntaId()){
                        preguntaDTO.setTipoPregunta(pregunta.getTipoPreguntaId().getDetalleTipoPregunta());
                        preguntaDTO.setCodigoTipoPregunta(pregunta.getTipoPreguntaId().getTipoPreguntaId());
                        listaOpciones.add("Si");
                        listaOpciones.add("No");
                        preguntaDTO.setOpcionMultiple(listaOpciones);
                    }else{
                        List<ItemsPreguntaEntity> items =  itemPreguntaRepository.findByPreguntaId(pregunta.getPreguntaId());
                        for (ItemsPreguntaEntity item:items) {
                            listaOpciones.add(contador + ". " + item.getOpcion());
                            contador++;
                        }
                        preguntaDTO.setOpcionMultiple(listaOpciones);
                    }
                    encuesta.add(preguntaDTO);
                }
                encuestaEntity.setFechaEncuesta(new Date());
                encuestaEntity.setCliente(clienteEntity.get());
                nuevaEncuesta = encuestaRepository.save(encuestaEntity);
                encuestaNuevaDTO.setEncuestaId(nuevaEncuesta.getEncuestaId());
                encuestaNuevaDTO.setPreguntaDTO(encuesta);
                return encuestaNuevaDTO;
            }else{
            	throw new MicroServiceException(STATUS_500,
						ERROR_CLIENTE_NO_EXISTE, null);
            }
        }catch (MicroServiceException e){
			throw new MicroServiceException(e.getStatus(),
					String.format(FORMATO_ERROR, GENERAR_ENCUESTA_SERVICE, METODO_GENERAR_ENCUESTA), e.getMensaje());
        }
	}

}
