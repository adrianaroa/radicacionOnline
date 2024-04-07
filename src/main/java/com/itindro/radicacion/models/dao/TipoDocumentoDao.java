package com.itindro.radicacion.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itindro.radicacion.models.entity.TipoDocumento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TipoDocumentoDao implements ITipoDocumentoDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<TipoDocumento> findAll() {
		
		return em.createQuery("from TipoDocumento WHERE tido_radonline != null").getResultList();
	}

}
