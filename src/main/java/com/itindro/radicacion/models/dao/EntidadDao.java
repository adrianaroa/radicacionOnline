package com.itindro.radicacion.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itindro.radicacion.models.entity.Entidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EntidadDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Entidad> find() {
		
		return em.createQuery("from Entidad").getResultList();
	}

}
