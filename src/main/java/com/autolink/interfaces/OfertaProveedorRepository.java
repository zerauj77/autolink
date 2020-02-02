package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.OfertaProveedor;
import com.autolink.model.Solicitud;

public interface OfertaProveedorRepository extends CrudRepository<OfertaProveedor, BigDecimal> {

	public Iterable<OfertaProveedor> findByIdSolicitud (Solicitud solicitud);
	


}
