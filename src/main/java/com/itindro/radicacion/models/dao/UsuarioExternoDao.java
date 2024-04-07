package com.itindro.radicacion.models.dao;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itindro.radicacion.models.entity.RadicacionComunicacion;
import com.itindro.radicacion.models.entity.UsuarioExterno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioExternoDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public UsuarioExterno find(String correo, String password) {
		
	  String query = "SELECT ue FROM UsuarioExterno ue WHERE ue.correo = :correo AND ue.password = :password";
        return em.createQuery(query, UsuarioExterno.class)
                 .setParameter("correo", correo)
                 .setParameter("password", password)
                 .getSingleResult();
	}
	
	@Transactional
	public UsuarioExterno findOrCreate(String correo, String password) {
		String query = "SELECT ue FROM UsuarioExterno ue WHERE ue.correo = :correo";
	    List<UsuarioExterno> usuarios = em.createQuery(query, UsuarioExterno.class)
	                                      .setParameter("correo", correo)
	                                      .getResultList();

	    if (usuarios.isEmpty()) {
	    	System.out.println("entraa");
	        UsuarioExterno nuevoUsuario = new UsuarioExterno();
	        nuevoUsuario.setCorreo(correo);

	        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
	        nuevoUsuario.setPassword(hashedPassword);
	    	System.out.println("entra111a");

	    	
	        em.persist(nuevoUsuario);
	    	System.out.println("entraa222");

	        return nuevoUsuario;
	    } else {
	        return usuarios.get(0);
	    }
	}
	

}
