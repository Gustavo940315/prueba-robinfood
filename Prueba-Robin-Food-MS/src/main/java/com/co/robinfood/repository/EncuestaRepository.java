package com.co.robinfood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.robinfood.model.EncuestaEntity;

@Repository
public interface EncuestaRepository extends CrudRepository<EncuestaEntity, Long> {

}
