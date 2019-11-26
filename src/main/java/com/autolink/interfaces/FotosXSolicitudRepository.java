package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.FotosXSolicitud;
import com.autolink.model.Solicitud;

public interface FotosXSolicitudRepository extends CrudRepository<FotosXSolicitud, BigDecimal> {

	
	public Iterable<FotosXSolicitud> findByIdSolicitud(Solicitud solicitud);
	public Iterable<FotosXSolicitud> findByIdSolicitud(BigDecimal id);
}
