package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Aseguradora;
import com.autolink.model.Solicitud;

public interface SolicitudRespository extends CrudRepository<Solicitud, BigDecimal> {

	public Solicitud findByCodigoSolicitud (String codigo);
	public Iterable<Solicitud> findByEstado (String estado);
	public Iterable<Solicitud> findByIdTaller_nombre (String nombre);
	


}
