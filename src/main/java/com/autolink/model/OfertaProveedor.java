package com.autolink.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ofertaproveedor")
public class OfertaProveedor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	BigDecimal id;
	Solicitud idSolicitud;
	Repuestos idRepuesto;
	Proveedor idProveedor;
	Integer cantidad;
	String estado;
	Date tiempoEntrega;
	boolean ganador;
	Integer tiempo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 11, scale = 0)
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "idsolicitud",insertable=true, updatable=true)
	public Solicitud getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Solicitud idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	@ManyToOne
	@JoinColumn(name = "idrepuesto",insertable=true, updatable=true)
	public Repuestos getIdRepuesto() {
		return idRepuesto;
	}
	
	public void setIdRepuesto(Repuestos idRepuesto) {
		this.idRepuesto = idRepuesto;
	}
	
	@ManyToOne
	@JoinColumn(name = "idproveedor",insertable=true, updatable=true)
	public Proveedor getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	@Column(name = "cantidad", length = 50)
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "estado", length = 50)
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name = "ganador", length = 1)
	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	
	
	@Column(name = "tiempo")
	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	
	

}
