package com.autolink.responses;

import java.math.BigDecimal;

public class LoginResponse implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal id;
	private String mensaje;
	private String nombre;
	private String user;
	private BigDecimal idTipo;
	private String tipo;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public BigDecimal getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(BigDecimal idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
		
		
	}
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	
	
	
	
	

}
