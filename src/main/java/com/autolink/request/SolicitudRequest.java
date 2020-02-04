package com.autolink.request;

import java.math.BigDecimal;

public class SolicitudRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String estado;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	


}
