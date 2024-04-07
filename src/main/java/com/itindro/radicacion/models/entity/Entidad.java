package com.itindro.radicacion.models.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"ENTIDAD\"", schema = "adminarccom")
public class Entidad  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "\"ENTIDAD_NOMBRE\"")
	public String nombre;
	
	@Column(name = "\"ENTIDAD_CORREORADICACION\"")
	public String correoradicacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoradicacion() {
		return correoradicacion;
	}

	public void setCorreoradicacion(String correoradicacion) {
		this.correoradicacion = correoradicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
