package com.itindro.radicacion.models.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"TIPODOCUMENTO\"", schema = "basico")
public class TipoDocumento  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"TIDO_ID\"" )
	public Integer tido_id;
	
	@Column(name = "\"TIDO_DESCRIPCION\"")
	public String tido_descripcion;
	
	@Column(name = "\"TIDO_RADONLINE\"")
	public String tido_radonline;
	

}
