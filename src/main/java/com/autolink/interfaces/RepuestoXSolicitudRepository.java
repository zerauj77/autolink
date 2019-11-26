package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.FotosXSolicitud;
import com.autolink.model.PreguntasXUsuario;
import com.autolink.model.RepuestoXSolicitudKeys;
import com.autolink.model.RepuestoXSolicitud;
import com.autolink.model.Solicitud;

public interface RepuestoXSolicitudRepository extends CrudRepository<RepuestoXSolicitud, RepuestoXSolicitudKeys> {

	
	public Iterable<RepuestoXSolicitud> findBySolicitud(Solicitud solicitud);
	public Iterable<RepuestoXSolicitud> findBySolicitud(BigDecimal id);
	public Iterable<RepuestoXSolicitud> findByRepuesto(BigDecimal id);
	
}
