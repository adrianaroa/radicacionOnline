package com.itindro.radicacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"TIPODOCUMENTO\"", schema = "\"COMUNICACIONES\"")

public class TipoSolicitud {

	@Id
	@Column(name = "\"TIPODOC_ID\"" )
	public Integer id;
	
	@Column(name = "\"TIPODOC_NOMBRE\"")
	public String nombre;
	
	@Column(name = "\"TIPODOC_TIPOPQRSD\"")
	public String tipoPQRSD;
	
	public Integer get_id() {
		return id;
	}

	public void set_id(Integer id) {
		this.id = id;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String get_tipoPQRSD() {
		return tipoPQRSD;
	}

	public void set_tipoPQRSD(String tipoPQRSD) {
		this.tipoPQRSD = tipoPQRSD;
	}
}
