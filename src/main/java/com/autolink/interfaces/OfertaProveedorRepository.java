package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.OfertaProveedor;
import com.autolink.model.Proveedor;
import com.autolink.model.Repuestos;
import com.autolink.model.Solicitud;

public interface OfertaProveedorRepository extends CrudRepository<OfertaProveedor, BigDecimal> {

	public Iterable<OfertaProveedor> findByIdSolicitud (Solicitud solicitud);
	public OfertaProveedor findByIdSolicitudAndIdRepuestoAndIdProveedor(Solicitud solicitud,Repuestos respuestos, Proveedor proveedor);
	public Iterable<OfertaProveedor> findDistinctByidProveedor(Proveedor proveedor);
	public Iterable<OfertaProveedor> findByIdProveedorAndIdSolicitud(Proveedor proveedor,Solicitud  solicitud);
	public Iterable<OfertaProveedor> findByIdProveedorAndIdSolicitud_Estado(Proveedor proveedor,String  estado);


}
	
