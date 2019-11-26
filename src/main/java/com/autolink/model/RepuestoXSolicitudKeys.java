package com.autolink.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class RepuestoXSolicitudKeys implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idrepuesto;
	private BigDecimal idsolicitud;
	
	@Column(name = "idrepuesto", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdrepuesto() {
		return idrepuesto;
	}
	public void setIdrepuesto(BigDecimal idrepuesto) {
		this.idrepuesto = idrepuesto;
	}
	
	@Column(name = "idsolicitud", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(BigDecimal idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	
	

}
