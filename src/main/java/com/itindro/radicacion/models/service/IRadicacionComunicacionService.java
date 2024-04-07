package com.itindro.radicacion.models.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.itindro.radicacion.models.entity.RadicacionComunicacion;

public interface IRadicacionComunicacionService {
	
	public void save(RadicacionComunicacion radicacionComunicacion, List<MultipartFile> files) throws IOException;
	
	//public RadicacionComunicacion buscarComunicacion(Long id, String identificacion);

}
