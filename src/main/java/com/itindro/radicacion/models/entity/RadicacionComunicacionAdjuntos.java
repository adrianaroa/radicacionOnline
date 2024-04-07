package com.itindro.radicacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "\"SOLICITUDRADICACIONWEBADJUNTO\"", schema = "\"COMUNICACIONES\"")
public class RadicacionComunicacionAdjuntos {
	
	@NotNull
	@NotEmpty
	@Column(name = "\"SOLIRADADJ_NOMBRE\"")
	private  String nombre;
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"SOLIRADADJ_ID\"" )
	private  Integer id;
	
	@NotNull
	@NotEmpty
	@Column(name = "\"SOLIRADADJ_IMAGEN\"")
	private  byte[] image;
	 
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"SOLIRAD_ID\"")
	
	private RadicacionComunicacion radicacionComunicacion;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}


	public void setId_id(Integer id) {
		this.id = id;
	}


	public RadicacionComunicacion getRadicacionComunicacion() {
		return radicacionComunicacion;
	}


	public void setRadicacionComunicacion(RadicacionComunicacion radicacionComunicacion) {
		this.radicacionComunicacion = radicacionComunicacion;
	}
	

}
