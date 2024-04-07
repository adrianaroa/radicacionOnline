package com.itindro.radicacion.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itindro.radicacion.models.entity.TipoDocumento;
import com.itindro.radicacion.models.entity.TipoSolicitud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TipoSolicitudDao implements ITipoSolicitudDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<TipoSolicitud> findAll() {
		
		return em.createQuery("from TipoSolicitud").getResultList();
	}
	
	public List<TipoSolicitud> findAllTipoPQRSD() {
		
		String jpql = "SELECT ts FROM TipoSolicitud ts WHERE ts.tipodoc_comunicacion = :condicion";
        return em.createQuery(jpql, TipoSolicitud.class)
	                 .setParameter("condicion", "1")
	                 .getResultList();
	        
		
	}

}
