package com.itindro.radicacion.models.dao;

import java.util.List;


import com.itindro.radicacion.models.entity.Municipio;

public interface IMunicipioDao {
	
	public List<Municipio> findAllDepartamento(String codigoDepartamento);

}