package com.itindro.radicacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "\"DEPARTAMENTO\"", schema = "basico")
public class Departamento {
	
	@Id
	@Column(name = "\"DEPARTAMENTO_ID\"" )
	public Integer departamento_id;
	
	@Column(name = "\"DEPARTAMENTO_CODIGO\"" )
	public String departamento_codigo;
	
	@Column(name = "\"DEPARTAMENTO_NOMBRE\"")
	public String departamento_nombre;
	
}
