package com.autolink.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class PreguntasXUsuarioKeys implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idRol;
	private BigDecimal idPantalla;
	
	
	@Column(name = "MDD_ROL_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdRol() {
		return idRol;
	}
	
	public void setIdRol(BigDecimal idRol) {
		this.idRol = idRol;
	}
	
	
	@Column(name = "MDD_PANTALLA_ID" ,unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdPantalla() {
		return idPantalla;
	}
	
	public void setIdPantalla(BigDecimal idPantalla) {
		this.idPantalla = idPantalla;
	}

}
