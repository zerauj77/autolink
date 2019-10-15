package com.autolink.request;

public class EstadoRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean estado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
