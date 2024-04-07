package com.itindro.radicacion.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.itindro.radicacion.models.entity.RadicacionComunicacion;
import com.itindro.radicacion.models.entity.RadicacionComunicacionAdjuntos;


public interface IRadicacionComunacionAdjuntoDao extends CrudRepository<RadicacionComunicacionAdjuntos, Integer> {

}
