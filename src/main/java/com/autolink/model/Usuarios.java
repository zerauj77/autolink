package com.autolink.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuarios implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String usuario;
	private String nombre;
	private String pass;
	private TipoUsuario tipo;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, precision = 11, scale = 0)
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "user", length = 50)
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "pass", length = 50)
	public String getContra() {
		return pass;
	}
	
	public void setContra(String contra) {
		this.pass = contra;
	}

	@ManyToOne
	@JoinColumn(name = "idtipo",insertable=false, updatable=false)
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	

	
	
}
