package com.autolink.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taller")
public class Taller implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	String nombre;
	private String usuariocrea;
	private boolean estado;
	private Date fechacreacion;
	
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	@Column(name = "nombreTaller", length = 50)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "usuariocrea", length = 50)
	public String getUsuariocrea() {
		return usuariocrea;
	}

	public void setUsuariocrea(String usuariocrea) {
		this.usuariocrea = usuariocrea;
	}

	@Column(name = "estado")
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	@Column(name = "fechacreacion")
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

}
