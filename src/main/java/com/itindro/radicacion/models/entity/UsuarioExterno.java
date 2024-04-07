package com.itindro.radicacion.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "\"USUARIOEXTERNO\"", schema = "\"EXTERNO\"")
public class UsuarioExterno  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"USUEXT_ID\"" )
	public Integer id;
	
	@Column(name = "\"USUEXT_CORREO\"")
	public String correo;
	
	@Column(name = "\"USUEXT_PASSWORD\"")
	public String password;
	
	@Column(name = "\"USUEXT_FECHAAUD\"")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaaud;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaaud() {
		return fechaaud;
	}

	@PrePersist
	public void setFechaAud() {
		this.fechaaud = new Date();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
