package com.autolink.responses;

import com.autolink.model.Proveedor;
import com.autolink.model.Repuestos;
import com.autolink.model.Solicitud;

public class SolicitudResponse implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Solicitud solicitud;
	private Iterable<Repuestos> repuestos;
	private Iterable<Proveedor> proveedor;
	private boolean ganador;
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public Iterable<Repuestos> getRepuestos() {
		return repuestos;
	}
	public void setRepuestos(Iterable<Repuestos> repuestos) {
		this.repuestos = repuestos;
	}

	public Iterable<Proveedor> getProveedor() {
		return proveedor;
	}
	public void setProveedor(Iterable<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}
	public boolean isGanador() {
		return ganador;
	}
	public void setGanador(boolean b) {
		this.ganador = b;
	}
	
	
	

}
