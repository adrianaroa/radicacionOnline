package com.itindro.radicacion.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itindro.radicacion.models.entity.TipoSolicitud;

public interface ITipoSolicitudDao {
	
	public List<TipoSolicitud> findAll();

	public List<TipoSolicitud> findAllTipoPQRSD();

}

