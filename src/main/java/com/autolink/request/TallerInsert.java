package com.autolink.request;

import java.math.BigDecimal;
import java.sql.Date;

import com.autolink.model.Usuarios;

public class TallerInsert implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	String nombre;
	private String usuariocrea;
	private boolean estado;
	private Date fechacreacion;
	private String razonsocial;
	private String cargo;
	private String telefono;
	private String usuario;
	private String direccion;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuariocrea() {
		return usuariocrea;
	}
	public void setUsuariocrea(String usuariocrea) {
		this.usuariocrea = usuariocrea;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
