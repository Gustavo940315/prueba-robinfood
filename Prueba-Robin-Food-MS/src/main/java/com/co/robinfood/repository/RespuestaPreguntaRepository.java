package com.co.robinfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.robinfood.model.RespuestaPreguntaEntity;

@Repository
public interface RespuestaPreguntaRepository extends CrudRepository<RespuestaPreguntaEntity, Long> {

	@Query("SELECT r FROM RespuestaPreguntaEntity r WHERE r.encuestaEntity.encuestaId = :id")
    public List<RespuestaPreguntaEntity> findByEncuestaId(@Param("id") long encuestaId);
}
