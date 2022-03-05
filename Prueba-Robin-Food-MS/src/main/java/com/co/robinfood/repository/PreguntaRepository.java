package com.co.robinfood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.robinfood.model.PreguntaEntity;

@Repository
public interface PreguntaRepository extends CrudRepository<PreguntaEntity,Long> {

}
