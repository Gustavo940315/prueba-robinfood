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
@Setter
@Getter
@Table(name="cliente")
public class ClienteEntity{

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long clienteId;

    @Column(name ="primer_nombre")
    private String primerNombre;

    @Column(name ="segundo_nombre")
    private String segundoNombre;

    @Column(name ="primer_apellido")
    private String primerApellido;

    @Column(name ="segundo_apellido")
    private String segundoApellido;

    private String celular;
}
