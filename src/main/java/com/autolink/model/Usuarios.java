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
@Table(name = "usuario")
public class Usuarios implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String usuario;
	private String nombre;
	private String pass;
	private TipoUsuario tipo;
	private String usuariocrea;
	private boolean estado;
	private Date fechacreacion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinColumn(name = "idtipo",insertable=true, updatable=false)
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
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
