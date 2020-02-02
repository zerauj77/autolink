package com.autolink.model;

import java.math.BigDecimal;

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
	
	@Column(name = "cantidad", length = 50,unique = true)
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "estado", length = 50,unique = true)
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
