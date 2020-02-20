package com.autolink.controller;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.OfertaProveedorRepository;
import com.autolink.interfaces.SolicitudRespository;
import com.autolink.model.OfertaProveedor;
import com.autolink.model.Solicitud;

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
		return oPRepository.findByIdSolicitud(solicitud);
	}
	
		
	public OfertaProveedor save(OfertaProveedor oferta){
		return oPRepository.save(oferta);
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
