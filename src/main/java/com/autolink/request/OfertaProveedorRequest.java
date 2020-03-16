package com.autolink.request;

public class OfertaProveedorRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	Integer cantidad;
	Integer tiempo;
	Double precio;
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getTiempo() {
		return tiempo;
	}
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	

}
