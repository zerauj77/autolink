package com.autolink.responses;

import java.math.BigDecimal;

public class OfertaResponse  implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BigDecimal id;
	BigDecimal idRepuesto;
	String repuesto;
	BigDecimal idProveedor;
	String proveedor;
	Integer cantidad;
	String estado;
	boolean ganador;
	Integer tiempo;
	Double precio;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getIdRepuesto() {
		return idRepuesto;
	}
	public void setIdRepuesto(BigDecimal idRepuesto) {
		this.idRepuesto = idRepuesto;
	}
	public String getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}
	public BigDecimal getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(BigDecimal idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isGanador() {
		return ganador;
	}
	public void setGanador(boolean ganador) {
		this.ganador = ganador;
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
