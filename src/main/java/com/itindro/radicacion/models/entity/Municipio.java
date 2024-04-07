package com.itindro.radicacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"MUNICIPIO\"", schema = "basico")
public class Municipio {

	@Id
	@Column(name = "\"MUNICIPIO_ID\"" )
	public Integer municipio_id;
	
	@Column(name = "\"MUNICIPIO_NOMBRE\"")
	public String municipio_nombre;
	
	@Column(name = "\"DEPARTAMENTO_CODIGO\"")
	public String departamento_codigo;

	public Integer getMunicipio_id() {
		return municipio_id;
	}

	public void setMunicipio_id(Integer municipio_id) {
		this.municipio_id = municipio_id;
	}

	public String getMunicipio_nombre() {
		return municipio_nombre;
	}

	public void setMunicipio_nombre(String municipio_nombre) {
		this.municipio_nombre = municipio_nombre;
	}

	public String getDepartamento_codigo() {
		return departamento_codigo;
	}

	public void setDepartamento_codigo(String departamento_codigo) {
		this.departamento_codigo = departamento_codigo;
	}
	
}
