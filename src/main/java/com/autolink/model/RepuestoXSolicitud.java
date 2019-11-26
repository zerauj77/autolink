package com.autolink.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuestoxsolicitud")
public class RepuestoXSolicitud implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RepuestoXSolicitudKeys id;
	private Repuestos repuesto;
	private Solicitud solicitud;
	private String estado;
	private boolean aplica;
	
	
	@Id
	@EmbeddedId
	public RepuestoXSolicitudKeys getId() {
		return id;
	}
	
	
	public void setId(RepuestoXSolicitudKeys id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "idrepuesto",insertable=false, updatable=false)
	public Repuestos getRepuesto() {
		return repuesto;
	}
	
	public void setRepuesto(Repuestos repuesto) {
		this.repuesto = repuesto;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "idsolicitud",insertable=false, updatable=false)
	public Solicitud getSolicitud() {
		return solicitud;
	}
	
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "aplica")
	public boolean isAplica() {
		return aplica;
	}
	
	public void setAplica(boolean aplica) {
		this.aplica = aplica;
	}

	
	
	
}
