package com.co.robinfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.robinfood.model.ItemsPreguntaEntity;

@Repository
public interface ItemPreguntaRepository extends CrudRepository<ItemsPreguntaEntity, Long> {

	  @Query("SELECT p FROM ItemsPreguntaEntity p WHERE p.pregunta.preguntaId = :id")
	    public List<ItemsPreguntaEntity>  findByPreguntaId(@Param("id") long l);
}
