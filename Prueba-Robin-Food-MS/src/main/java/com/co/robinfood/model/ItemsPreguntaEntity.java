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
@Table(name="items_pregunta")
@Getter
@Setter
public class ItemsPreguntaEntity {

	@Id
    @Column(name = "items_pregunta_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long itemsPreguntaId;

    @ManyToOne
    @JoinColumn(name ="pregunta_id")
    private PreguntaEntity  pregunta;

    private String opcion;
}
