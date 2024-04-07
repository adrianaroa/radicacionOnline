package com.itindro.radicacion.models.dao;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itindro.radicacion.models.entity.Municipio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MunicipioDao implements IMunicipioDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Municipio> findAllDepartamento(String codigoDepartamento) {
	
		
		String jpql = "SELECT e FROM Municipio e WHERE e.departamento_codigo = :valorBuscado";
		Query query =  em.createQuery(jpql);

		// Establece el valor del parámetro :valorBuscado en la consulta
		query.setParameter("valorBuscado", codigoDepartamento);

		List<Municipio> resultados = query.getResultList();

		
//		Query query = (Query) em.createQuery("SELECT p FROM Municipio p WHERE p.departamento_codigo = :codigoDepartamento");
//		((jakarta.persistence.Query) query).setParameter("codigoDepartamento", "64");
//		
		return  resultados;
		//		return em.createQuery("SELECT  from Municipio where DEPARTAMENTO_CODIGO = " + codigoDepartamento).getResultList();
	}

}
