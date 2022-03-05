package com.co.robinfood.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntaDTO {

    private long preguntaId;

    private String titulo;

    private String tipoPregunta;

    private long codigoTipoPregunta;

    private List<String> opcionMultiple;
}
