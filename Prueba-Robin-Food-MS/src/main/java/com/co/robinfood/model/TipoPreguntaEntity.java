package com.co.robinfood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tipo_pregunta")
@Getter
@Setter
public class TipoPreguntaEntity {

    @Id
    @Column(name = "tipo_pregunta_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long tipoPreguntaId;

    @Column(name = "detalle_tipo_pregunta")
    private String detalleTipoPregunta;
}
