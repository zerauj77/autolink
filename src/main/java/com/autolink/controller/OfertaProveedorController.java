package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.OfertaProveedorRepository;
import com.autolink.interfaces.SolicitudRespository;
import com.autolink.model.OfertaProveedor;
import com.autolink.model.Solicitud;
import com.autolink.responses.GenericResponse;

public class OfertaProveedorController {
	
	@Autowired
	OfertaProveedorRepository oPRepository;
	
	@Autowired
	SolicitudRespository solRepository;
	
	
	public Iterable<OfertaProveedor> getAllOfertaProveedor() {
		return oPRepository.findAll();
	}
	
	public Iterable<OfertaProveedor> getAllOfertaProveedorBySolicitud(BigDecimal id) {
		Solicitud solicitud = solRepository.findById(id).orElse(null); 
		if(solicitud == null) {
			return null;
		}
		return oPRepository.findByIdSolicitud(solicitud);
	}
	
		
	public OfertaProveedor save(OfertaProveedor oferta){
		return oPRepository.save(oferta);
	}
	
	
	public GenericResponse guardarGanador(BigDecimal id) {
		GenericResponse resp = new GenericResponse();
		if(oPRepository.existsById(id)) {
			OfertaProveedor op = oPRepository.findById(id).orElse(null);
			op.setGanador(true);
			resp.setCodigo(200);
			resp.setMensaje("Guardado con Exito");
			oPRepository.save(op);
			return resp;
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
		
	}
	
	

//	public void getBestRoute(BigDecimal idSolicitud, BigDecimal idRepuesto){
//		Iterable<OfertaProveedor> ofertas =  this.getAllOfertaProveedorBySolicitud(idSolicitud);
//		
//		Map<Object, Double> lista = StreamSupport.stream(ofertas.spliterator(), false)
//                .collect(groupingBy(ofertaProveedor -> ofertaProveedor.getIdRepuesto().getId(),
//                Collectors.maxBy(Collectors.summarizingDouble(ofertaProveedor -> ofertaProveedor.getIdRepuesto().getCantidad))));
//				
//		
//	}
	
}
