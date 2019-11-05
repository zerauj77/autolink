package com.autolink.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class PreguntasXUsuarioKeys implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idusuarios;
	private BigDecimal idpregunta;
	
	
	@Column(name = "idusuario", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdUsuarios() {
		return idusuarios;
	}
	
	public void setIdUsuarios(BigDecimal idUsuarios) {
		this.idusuarios = idUsuarios;
	}
	
	
	@Column(name = "idpregunta" ,unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdPregunta() {
		return idpregunta;
	}
	
	public void setIdPregunta(BigDecimal idpregunta) {
		this.idpregunta = idpregunta;
	}

}
