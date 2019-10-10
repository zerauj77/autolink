package com.autolink.request;

import java.math.BigDecimal;
import java.sql.Date;

public class UsuarioRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String usuario;
	private String nombre;
	private String pass;
	private String email;
	private BigDecimal tipo;
	private Date fechaCreacion;
	private String usuarioCrea;
	private Boolean estado;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getTipo() {
		return tipo;
	}
	public void setTipo(BigDecimal tipo) {
		this.tipo = tipo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	

}
