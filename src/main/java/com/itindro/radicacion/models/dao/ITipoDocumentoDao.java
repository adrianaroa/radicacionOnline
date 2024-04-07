package com.itindro.radicacion.models.dao;

import java.util.List;

import com.itindro.radicacion.models.entity.TipoDocumento;


public interface ITipoDocumentoDao {
	
	public List<TipoDocumento> findAll();

}
