package com.itindro.radicacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itindro.radicacion.models.dao.IMunicipioDao;
import com.itindro.radicacion.models.entity.Municipio;

@RestController
public class MunicipioController {

	@Autowired
	private IMunicipioDao MunicipioDao;
	
	@ModelAttribute("Municipio") 
 	public  List<Municipio> listarMunicipiosDepartamento() {
        return  MunicipioDao.findAllDepartamento("09");
    }
	
	@GetMapping("/municipios/{departamento}")
	public List<Municipio> listar(@ModelAttribute("Municipio") Municipio municipios, @PathVariable(value="departamento") String departamento, Model model) {
		return  MunicipioDao.findAllDepartamento(departamento);
	}
}
