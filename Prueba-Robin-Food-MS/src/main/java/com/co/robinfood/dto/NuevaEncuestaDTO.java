package com.co.robinfood.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NuevaEncuestaDTO {

    private long encuestaId;

    private List<PreguntaDTO> preguntaDTO;
}
