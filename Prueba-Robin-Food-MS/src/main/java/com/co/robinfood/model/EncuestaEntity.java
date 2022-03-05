package com.co.robinfood.model;

import java.util.Date;

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
@Table(name="encuesta")
@Getter
@Setter
public class EncuestaEntity {

	@Id
    @Column(name = "encuesta_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long encuestaId;

    @ManyToOne
    @JoinColumn(name ="cliente_id")
    private ClienteEntity cliente;

    @Column(name = "fecha_encuesta")
    private Date fechaEncuesta;
}
