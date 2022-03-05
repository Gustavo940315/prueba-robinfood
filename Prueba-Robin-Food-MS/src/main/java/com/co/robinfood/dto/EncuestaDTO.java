package com.co.robinfood.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncuestaDTO {

    private String cliente;

    private List<RespuestaEncuestaDTO> listaRespuestas;
}
