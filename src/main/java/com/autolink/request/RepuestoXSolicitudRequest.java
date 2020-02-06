package com.autolink.request;

import java.math.BigDecimal;

public class RepuestoXSolicitudRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private BigDecimal idRepuesto;
	private String estado;
	private boolean aplica;


	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getIdRepuesto() {
		return idRepuesto;
	}
	public void setIdRepuesto(BigDecimal idRepuesto) {
		this.idRepuesto = idRepuesto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isAplica() {
		return aplica;
	}
	public void setAplica(boolean aplica) {
		this.aplica = aplica;
	}
	
	
}
