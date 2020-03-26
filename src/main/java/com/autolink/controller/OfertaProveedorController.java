package com.autolink.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.OfertaProveedorRepository;
import com.autolink.interfaces.ProveedorRepository;
import com.autolink.interfaces.RepuestoRepository;
import com.autolink.interfaces.SolicitudRespository;
import com.autolink.model.OfertaProveedor;
import com.autolink.model.Proveedor;
import com.autolink.model.Repuestos;
import com.autolink.model.Solicitud;
import com.autolink.request.NewOferta;
import com.autolink.request.OfertaProveedorRequest;
import com.autolink.responses.GenericResponse;
import com.autolink.responses.OfertaResponse;
import com.autolink.responses.SolicitudResponse;

public class OfertaProveedorController {
	
	@Autowired
	OfertaProveedorRepository oPRepository;
	
	@Autowired
	SolicitudRespository solRepository;
	
	
	@Autowired
	ProveedorRepository proRepository;
	
	
	@Autowired
	RepuestoRepository reRepository;
	
	
	
	
	
	public Iterable<OfertaProveedor> getAllOfertaProveedor() {
		return oPRepository.findAll();
	}
	
	public Iterable<OfertaResponse> getAllOfertaProveedorBySolicitudAndByProveedor(BigDecimal idSolicitud,BigDecimal idProveedor){
		List<OfertaResponse> resp = new ArrayList<OfertaResponse>();
		OfertaResponse oferta;
		Solicitud solicitud = solRepository.findById(idSolicitud).orElse(null); 
		if(solicitud == null) {
			return null;
		}
		Proveedor proveedor = proRepository.findById(idProveedor).orElse(null); 
		if(proveedor == null) {
			return null;
		}
		
		Iterable<OfertaProveedor> ofertas = oPRepository.findByIdProveedorAndIdSolicitud(proveedor, solicitud);
		for (OfertaProveedor obj : ofertas) {
			oferta = new OfertaResponse();
			oferta.setCantidad(obj.getCantidad());
			oferta.setEstado(obj.getEstado());
			oferta.setGanador(obj.isGanador());
			oferta.setId(obj.getId());
			oferta.setIdProveedor(obj.getIdProveedor().getId());
			oferta.setIdRepuesto(obj.getIdRepuesto().getId());
			oferta.setProveedor(obj.getIdProveedor().getNombre());
			oferta.setRepuesto(obj.getIdRepuesto().getNombre());
			oferta.setTiempo(obj.getTiempo());
			oferta.setPrecio(obj.getPrecio());
			resp.add(oferta);
		}
		return resp;
	}
	
	public Iterable<OfertaResponse> getAllOfertaProveedorBySolicitud(BigDecimal id) {
		List<OfertaResponse> resp = new ArrayList<OfertaResponse>();
		Solicitud solicitud = solRepository.findById(id).orElse(null); 
		OfertaResponse oferta;
		if(solicitud == null) {
			return null;
		}
		Iterable<OfertaProveedor> ofertas =  oPRepository.findByIdSolicitud(solicitud);
		for (OfertaProveedor obj : ofertas) {
			oferta = new OfertaResponse();
			oferta.setCantidad(obj.getCantidad());
			oferta.setEstado(obj.getEstado());
			oferta.setGanador(obj.isGanador());
			oferta.setId(obj.getId());
			oferta.setIdProveedor(obj.getIdProveedor().getId());
			oferta.setIdRepuesto(obj.getIdRepuesto().getId());
			oferta.setProveedor(obj.getIdProveedor().getNombre());
			oferta.setRepuesto(obj.getIdRepuesto().getNombre());
			oferta.setTiempo(obj.getTiempo());
			oferta.setPrecio(obj.getPrecio());
			resp.add(oferta);
		}
		return resp;
				
	}
	
	public OfertaProveedor save(OfertaProveedor oferta) {
		return oPRepository.save(oferta);
	}
	
		
	public OfertaProveedor save(NewOferta oferta){
		OfertaProveedor resp = new OfertaProveedor();
		Solicitud solicitud = solRepository.findById(oferta.getIdSolicitud()).orElse(null); 
		if(solicitud == null) {
			return null;
		}
		Proveedor proveedor = proRepository.findById(oferta.getIdProveedor()).orElse(null); 
		if(proveedor == null) {
			return null;
		}
		Repuestos repuesto = reRepository.findById(oferta.getIdRepuesto()).orElse(null); 
		if(repuesto == null) {
			return null;
		}
		resp.setCantidad(oferta.getCantidad());
		resp.setEstado(oferta.getEstado());
		resp.setGanador(oferta.isGanador());
		resp.setIdSolicitud(solicitud);
		resp.setIdRepuesto(repuesto);
		resp.setTiempo(oferta.getTiempo());
		resp.setIdProveedor(proveedor);
		resp.setPrecio(oferta.getPrecio());
		return oPRepository.save(resp);
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
	
	public GenericResponse guardarGanadorAll(BigDecimal id, BigDecimal idProveedor) {
		GenericResponse resp = new GenericResponse();
		Solicitud solicitud = solRepository.findById(id).orElse(null); 
		if(solicitud == null) {
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
		}
		Proveedor proveedor = proRepository.findById(idProveedor).orElse(null); 
		if(proveedor == null) {
			return null;
		}
		
		Iterable<OfertaProveedor> lista = oPRepository.findByIdProveedorAndIdSolicitud(proveedor, solicitud);
		
		 lista.forEach(new Consumer<OfertaProveedor>() { 
			  
	       
				@Override
				public void accept(OfertaProveedor arg0) {
					arg0.setGanador(true);
					oPRepository.save(arg0);
				
				} 
	  
	        }); 
		 	resp.setCodigo(200);
			resp.setMensaje("Guardado con exito");
			return resp;
		
	}
	

	
	public boolean isGanador(BigDecimal id,BigDecimal idProveedor) {
		boolean validacion = false;
		Solicitud solicitud = solRepository.findById(id).orElse(null); 
		if(solicitud == null) {
			return validacion;
		};
		Proveedor proveedor = proRepository.findById(idProveedor).orElse(null); 
		if(proveedor == null) {
			return validacion;
		}
		
		Iterable<OfertaProveedor> lista = oPRepository.findByIdProveedorAndIdSolicitud(proveedor, solicitud);
		
		for (OfertaProveedor obj : lista) {
			   if (obj.isGanador()) {
			      validacion = true;
				   break; // or return obj
			   }
			};
		 	return validacion;
		
	}
	
	
	public Iterable<SolicitudResponse> proveedorGanador(String estado,BigDecimal idProveedor) {
		SolicitudResponse resp = new SolicitudResponse();
		
		Iterable<Solicitud> lista = solRepository.findByEstado(estado);
		if(lista == null) {
			return  null;
		}
		List<SolicitudResponse> listaResp = new ArrayList<SolicitudResponse>();
		for (Solicitud obj : lista) {
			
			   resp.setSolicitud(obj);
			   resp.setGanador(this.isGanador(obj.getId(),idProveedor));
			   listaResp.add(resp);
			};
		return listaResp;
	}
	
	public SolicitudResponse infoGanador(BigDecimal id) {
		Solicitud solicitud = solRepository.findById(id).orElse(null); 
		if(solicitud == null) {
			return null;
		};
		
		SolicitudResponse resp = new SolicitudResponse();
		List<Repuestos> listaResp = new ArrayList<Repuestos>();
		List<Proveedor> listaprov = new ArrayList<Proveedor>();

		Iterable<OfertaProveedor> ofertas = oPRepository.findByIdSolicitud(solicitud);
		
		for (OfertaProveedor obj : ofertas) {
				
				
			   listaResp.add(obj.getIdRepuesto());
			   listaprov.add(obj.getIdProveedor());
			   
			   
			   
			};
		  resp.setSolicitud(solicitud);
		  resp.setProveedor(listaprov);
		  resp.setRepuestos(listaResp);
		  
		return resp;
		
	}

	
	
	public OfertaProveedor update(BigDecimal id, OfertaProveedorRequest opr) {
		if(oPRepository.existsById(id)) {
			OfertaProveedor op = oPRepository.findById(id).orElse(null);
			if(opr.getCantidad() != null) {
				op.setCantidad(opr.getCantidad());
			}
			if(opr.getTiempo() != null) {
				op.setTiempo(opr.getTiempo());
			}
			if(opr.getPrecio() != null) {
				op.setPrecio(opr.getPrecio());
			}
			return oPRepository.save(op);
		 
		}else
			return null;
	}
	
	
	
	public GenericResponse delete(BigDecimal id) {
		GenericResponse resp = new GenericResponse();
		oPRepository.deleteById(id);
		resp.setCodigo(100);
		resp.setMensaje("Registro eliminado con exito");
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
