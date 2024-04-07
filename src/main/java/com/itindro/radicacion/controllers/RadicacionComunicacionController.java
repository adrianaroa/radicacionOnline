package com.itindro.radicacion.controllers;
//ult

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.itindro.radicacion.models.dao.IDepartamentoDao;
//import com.itindro.radicacion.models.dao.IDepartamento;
import com.itindro.radicacion.models.dao.ITipoDocumentoDao;
import com.itindro.radicacion.models.dao.ITipoSolicitudDao;
import com.itindro.radicacion.models.entity.Departamento;
import com.itindro.radicacion.models.entity.RadicacionComunicacion;
import com.itindro.radicacion.models.entity.TipoDocumento;
import com.itindro.radicacion.models.entity.TipoSolicitud;
import com.itindro.radicacion.models.service.IRadicacionComunicacionService;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
@SessionAttributes("radicacioncomunicacion, TipoDocumento, Departamento")

public class RadicacionComunicacionController {
	
	@Autowired
	private ITipoDocumentoDao TipoIdentificacionDao;
	
	@Autowired
	private IDepartamentoDao DepartamentoDao;
	
	@Autowired
	private IRadicacionComunicacionService radicacionComunicacionService;
	
	@Autowired
	private ITipoSolicitudDao TipoSolicitudDao;
	

	@ModelAttribute("TipoDocumento") 
 	public  List<TipoDocumento> tiposDocumento() {
        return  TipoIdentificacionDao.findAll();
    }
	
	@ModelAttribute("Departamento")
	public Iterable<Departamento> departamentos(){
		return DepartamentoDao.findAll();
	}
	
	@ModelAttribute("RadicacionComunicacion") 
 	public  RadicacionComunicacion radicacionComunicacion() {
		RadicacionComunicacion radicacioncomunicacion = new RadicacionComunicacion();
        return  radicacioncomunicacion;
	}
	
	@ModelAttribute("TipoSolicitud")
	public Iterable<TipoSolicitud> tipoSolicitud(){
		return TipoSolicitudDao.findAll();
	}
	
	@RequestMapping(value = "/comunicacion", method = RequestMethod.GET)
	public String SolicitudComunicacion(@ModelAttribute("TipoDocumento") TipoDocumento usuario, Model model) {
		RadicacionComunicacion radicacioncomunicacion = new RadicacionComunicacion();
		model.addAttribute("radicacioncomunicacion", radicacioncomunicacion);
		//model.addAttribute("TipoDocumento", TipoIdentificacionDao.findAll());
		model.addAttribute("titulo", "Radicar Comunicación Oficial");
		return "comunicacion/solicitudRadicacion";
	}
	
	@RequestMapping(value = "/pqrsd", method = RequestMethod.GET)
	public String SolicitudPQRSD(@ModelAttribute("TipoDocumento") TipoDocumento usuario, Model model) {
		RadicacionComunicacion radicacioncomunicacion = new RadicacionComunicacion();
		model.addAttribute("radicacioncomunicacion", radicacioncomunicacion);
		//model.addAttribute("TipoDocumento", TipoIdentificacionDao.findAll());
		model.addAttribute("titulo", "Radicar PQRSDF");
		return "pqrsd/solicitudRadicacion";
	}
	
	
	@RequestMapping(value = "/solicitudRadicacion", method = RequestMethod.POST)
	public ResponseEntity<String>  guardar(@ModelAttribute("radicacioncomunicacion") @Valid RadicacionComunicacion radicacioncomunicacion, BindingResult result, @RequestParam("files") List<MultipartFile> files, Model model, SessionStatus status,HttpSession session) throws IOException {
        System.out.println("estraaa");
        ObjectMapper objectMapper = new ObjectMapper();
        String erroresJson = "";
		try {
			model.addAttribute("titulo", "Radicar Comunicación Oficial");
			System.out.print("tamañoo" + files.size());
		
			System.out.println(files.isEmpty());

			if (files.size() < 10) {
				
			}
			
			for (MultipartFile file : files) {
			    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			    long fileSize = file.getSize();  
			    System.out.println(file.getSize());
			    
			    if ( file.getSize() < 10 ) {
				    FieldError sizeError = new FieldError("radicacioncomunicacion", "file", "Debe adjuntar archivo");
					result.addError(sizeError);
					break;
			    }

				
			    if (file.getSize() > 10 * 1024 * 1024) {
					FieldError sizeError = new FieldError("radicacioncomunicacion", "file", "El tamaño del archivo no debe exceder los 10MB");
			        result.addError(sizeError); 
			    }
			}
			
			if (result.hasErrors()) {
				FieldError sizeError = new FieldError("radicacioncomunicacion", "file", "El tamaño del archivo no debe exceder los 10MB");

		        erroresJson = objectMapper.writeValueAsString(result.getAllErrors());
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroresJson);
		    } else {
		        
		    	radicacionComunicacionService.save(radicacioncomunicacion, files);
				status.setComplete();
		        session.setAttribute("radicacioncomunicacion", radicacioncomunicacion);
		        return ResponseEntity.ok("Solicitud procesada exitosamente");
		    }
		}
		catch (Exception e) {
			FieldError sizeError = new FieldError("radicacioncomunicacion", "file", "Ocurrió un error el procesar la información ");
	        result.addError(sizeError); 
	        erroresJson = objectMapper.writeValueAsString(result.getAllErrors());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroresJson);
		}
			
		/*
        ObjectMapper objectMapper = new ObjectMapper();
        String erroresJson = objectMapper.writeValueAsString(result.getAllErrors());
        System.err.println(erroresJson);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroresJson);
*/
        
		//radicacionComunicacionService.save(radicacioncomunicacion, files);
		//status.setComplete();
       // session.setAttribute("radicacioncomunicacion", radicacioncomunicacion);

		//return "redirect:solicitudRegistrada";

	}
	
	@RequestMapping(value = "/solicitudRegistrada", method = RequestMethod.GET)
	public String solicitudRadiccacion(@ModelAttribute("radicacioncomunicacion") RadicacionComunicacion radicacioncomunicacion, Model model) {
		model.addAttribute("titulo", "Radicar Comunicación Oficial");
		return "solicitudRegistrada";
	}
	

}
