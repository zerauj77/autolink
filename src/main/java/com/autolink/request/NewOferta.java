package com.autolink.request;

import java.math.BigDecimal;
import java.util.Date;

import com.autolink.model.Proveedor;
import com.autolink.model.Repuestos;
import com.autolink.model.Solicitud;

public class NewOferta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal idSolicitud;
	private BigDecimal idRepuesto;
	private BigDecimal idProveedor;
	private Integer cantidad;
	private String estado;
	private boolean ganador;
	private Integer tiempo;
	private Double precio;
	
	public BigDecimal getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public BigDecimal getIdRepuesto() {
		return idRepuesto;
	}
	public void setIdRepuesto(BigDecimal idRepuesto) {
		this.idRepuesto = idRepuesto;
	}
	public BigDecimal getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(BigDecimal idProveedor) {
		this.idProveedor = idProveedor;
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
