package com.itindro.radicacion.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "\"SOLICITUDRADICACIONWEB\"", schema = "\"COMUNICACIONES\"")

public class RadicacionComunicacion  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Integer getRadId() {
		return radId;
	}

	public void setRadId(Integer radId) {
		this.radId = radId;
	}

	public Integer getRad_tipoidentificacion() {
		return rad_tipoidentificacion;
	}

	public void setRad_tipoidentificacion(Integer rad_tipoidentificacion) {
		this.rad_tipoidentificacion = rad_tipoidentificacion;
	}

	public String getRad_identificacion() {
		return rad_identificacion;
	}

	public void setRad_identificacion(String rad_identificacion) {
		this.rad_identificacion = rad_identificacion;
	}

	public String getRad_nombres() {
		return rad_nombres;
	}

	public void setRad_nombres(String rad_nombres) {
		this.rad_nombres = rad_nombres;
	}

	public String getRad_primerapellido() {
		return rad_primerapellido;
	}

	public void setRad_primerapellido(String rad_primerapellido) {
		this.rad_primerapellido = rad_primerapellido;
	}

	public String getRad_segundoapellido() {
		return rad_segundoapellido;
	}

	public void setRad_segundoapellido(String rad_segundoapellido) {
		this.rad_segundoapellido = rad_segundoapellido;
	}

	public String getRad_direccion() {
		return rad_direccion;
	}

	public void setRad_direccion(String rad_direccion) {
		this.rad_direccion = rad_direccion;
	}

	public String getRad_barrio() {
		return rad_barrio;
	}

	public void setRad_barrio(String rad_barrio) {
		this.rad_barrio = rad_barrio;
	}

	public Integer getRad_municipio() {
		return rad_municipio;
	}

	public void setRad_municipio(Integer rad_municipio) {
		this.rad_municipio = rad_municipio;
	}
	
	public Integer getRad_departamento() {
		return rad_departamento;
	}

	public void setRad_departamento(Integer rad_departamento) {
		this.rad_departamento = rad_departamento;
	}


	public String getRad_telefono() {
		return rad_telefono;
	}

	public void setRad_telefono(String rad_telefono) {
		this.rad_telefono = rad_telefono;
	}

	public String getRad_correo() {
		return rad_correo;
	}

	public void setRad_correo(String rad_correo) {
		this.rad_correo = rad_correo;
	}

	public String getRad_asunto() {
		return rad_asunto;
	}

	public void setRad_asunto(String rad_asunto) {
		this.rad_asunto = rad_asunto;
	}

	public String getRad_resumen() {
		return rad_resumen;
	}

	public void setRad_resumen(String rad_resumen) {
		this.rad_resumen = rad_resumen;
	}
	
	public Date getRad_registroAud() {
		return rad_registroAud;
	}
	
	public Integer getRad_tiposolicitud() {
		return rad_tiposolicitud;
	}

	public void setRad_tiposolicitud(Integer rad_tiposolicitud) {
		this.rad_tiposolicitud = rad_tiposolicitud;
	}
	
	public Integer getRad_tipo() {
		return rad_tipo;
	}

	public void setRad_tipo(Integer rad_tipo) {
		this.rad_tipo = rad_tipo;
	}
	
	public String getRad_funcionario() {
		return rad_funcionario;
	}
	
	public void setRad_funcionario(String rad_funcionario) {
		this.rad_funcionario = rad_funcionario;
	}
	
	public String getRad_funcionariocargo() {
		return rad_funcionariocargo;
	}
	public void setRad_funcionariocargo(String rad_funcionariocargo) {
		this.rad_funcionariocargo = rad_funcionariocargo;
	}
	



	@PrePersist
	public void setRad_registroAud() {
		this.rad_registroAud = new Date();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"RAD_ID\"" )
	private  Integer radId;
	
	@NotNull(message = "El tipo de identificación no puede estar vacío")
	@Column(name = "\"TIDO_ID\"")
	private  Integer rad_tipoidentificacion;
	
	@NotNull(message = "El número de identificación no puede estar vacío")
	@Column(name = "\"RAD_IDENTIFICACION\"")
	private  String rad_identificacion;
	
	@Column(name = "\"RAD_NOMBRES\"")
	private  String rad_nombres;
	
	@NotNull
	@Column(name = "\"RAD_PRIMERAPELLIDO\"")
	private  String rad_primerapellido;
	
	@Column(name = "\"RAD_SEGUNDOAPELLIDO\"")
	private  String rad_segundoapellido;
	
	@Column(name = "\"RAD_DIRECCION\"")
	private  String rad_direccion;
	
	@Column(name = "\"RAD_BARRIO\"")
	private  String rad_barrio;
	
	@Column(name = "\"MUNICIPIO_ID\"")
	private  Integer rad_municipio;
	
	@Column(name = "\"DEPARTAMENTO_ID\"")
	private  Integer rad_departamento;
	
	@Column(name = "\"RAD_TELEFONO\"")
	private  String rad_telefono;
	
	@NotNull
	@jakarta.validation.constraints.Email
	@Column(name = "\"RAD_CORREO\"")
	private  String rad_correo;
	
	@NotNull(message = "El asunto no puede estar vacío")
	@NotEmpty(message = "El asunto no puede estar vacío")
	@Column(name = "\"RAD_ASUNTO\"")
	private  String rad_asunto;
		

	@Column(name = "\"RAD_TIPO\"")
	private  Integer rad_tipo;
	
	@Column(name = "\"TIPODOC_ID\"")
	private  Integer rad_tiposolicitud;
	
	
	@NotNull(message = "El resumen no puede estar vacío")
	@NotEmpty(message = "El resumen no puede estar vacío")
	@Column(name = "\"RAD_RESUMEN\"")
	private  String rad_resumen;
	
	@Column(name = "\"RAD_FUNCIONARIO\"")
	private  String rad_funcionario;
	
	@Column(name = "\"RAD_FUNCIONARIOCARGO\"")
	private  String rad_funcionariocargo;
	
	
	@Column(name = "\"RAD_REGISTROAUD\"")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date rad_registroAud;
}

