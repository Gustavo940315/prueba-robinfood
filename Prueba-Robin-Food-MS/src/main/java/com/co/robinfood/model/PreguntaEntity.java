package com.co.robinfood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pregunta")
@Getter
@Setter
public class PreguntaEntity {

    @Id
    @Column(name = "pregunta_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long preguntaId;

    @ManyToOne
    @JoinColumn(name ="tipo_pregunta_id")
    private TipoPreguntaEntity  tipoPreguntaId;

    private String titulo;
}
