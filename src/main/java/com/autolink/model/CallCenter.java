package com.autolink.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "callcenter")
public class CallCenter implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String nombre;
	private String usuariocrea;
	private boolean estado;
	private Date fechacreacion;
	private String razonsocial;
	private String cargo;
	private String telefono;
	private Usuarios usuario;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	@Column(name = "nombreempresa", length = 50,unique = true)
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

	@Column(name = "razonsocial")
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	@Column(name = "cargo")
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@ManyToOne
	@JoinColumn(name = "idusuario",insertable=true, updatable=true)
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	


}
