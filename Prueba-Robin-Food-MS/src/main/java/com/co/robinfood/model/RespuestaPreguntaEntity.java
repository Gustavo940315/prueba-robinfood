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
@Table(name = "respuesta_x_pregunta")
@Getter
@Setter
public class RespuestaPreguntaEntity {

	@Id
	@Column(name = "respuesta_x_pregunta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long respuestaXpreguntaId;

	@ManyToOne
	@JoinColumn(name = "encuesta_id")
	private EncuestaEntity encuestaEntity;

	@ManyToOne
	@JoinColumn(name = "pregunta_id")
	private PreguntaEntity preguntaEntity;

	private String respuesta;

	private String pregunta;
}
