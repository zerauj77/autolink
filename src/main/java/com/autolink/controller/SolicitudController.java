package com.autolink.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.autolink.interfaces.FotosXSolicitudRepository;
import com.autolink.interfaces.RepuestoRepository;
import com.autolink.interfaces.RepuestoXSolicitudRepository;
import com.autolink.interfaces.SolicitudRespository;
import com.autolink.model.FotosXSolicitud;
import com.autolink.model.RepuestoXSolicitud;
import com.autolink.model.RepuestoXSolicitudKeys;
import com.autolink.model.Repuestos;
import com.autolink.model.Solicitud;
import com.autolink.request.FilesRequest;
import com.autolink.request.RepuestoXSolicitudRequest;
import com.autolink.responses.GenericResponse;

public class SolicitudController {

	@Autowired
	FotosXSolicitudRepository fSRepository;
	
	@Autowired
	SolicitudRespository solRepository;
	
	@Autowired
	RepuestoRepository rRepository;
	
	@Autowired
	RepuestoXSolicitudRepository rSRepository;
	
	
	public Iterable<Solicitud> getAllSolicitud() {
		return solRepository.findAll();
	}
	
	public String generateSolicud() {
		return RandomStringUtils.randomAlphabetic(10);
		
	}
	
	public Iterable<RepuestoXSolicitud> getAllRepuestoXSolicitudBySolicitud(BigDecimal id) {
		Solicitud sol = solRepository.findById(id).orElse(null);
		return rSRepository.findBySolicitud(sol);
	}
	
	public Iterable<FotosXSolicitud> getAllFotosXSolicitud(BigDecimal id) {
		return fSRepository.findByIdSolicitud(id);
	}
	
	public Solicitud getOneSolicitudByCode(String codigo){
		return solRepository.findByCodigoSolicitud(codigo);
	}
	
	public Solicitud save(Solicitud usu){
		return solRepository.save(usu);
	}
	
	public Solicitud update(Solicitud usu) {
		if(solRepository.existsById(usu.getId())) {
			Solicitud sol = solRepository.findById(usu.getId()).orElse(new Solicitud());
			if(sol.getComentariosAseguradora() != null) {
				sol.setComentariosAseguradora(usu.getComentariosAseguradora());
			}
			if(sol.getComentariosProveedores() != null) {
				sol.setComentariosProveedores(usu.getComentariosProveedores());
			}
			
			if(sol.getComentariosTaller() != null) {
				sol.setComentariosTaller(usu.getComentariosTaller());
			}
			if(sol.getEstado() != null) {
				sol.setEstado(usu.getEstado());
			}
			if(sol.getFechaInicio() != null) {
				sol.setFechaInicio(usu.getFechaInicio());
			}
			if(sol.getFechaFin() != null) {
				sol.setFechaFin(usu.getFechaFin());
			}
			return sol;
		}else
			return new Solicitud();
			
	}
	
	public GenericResponse updateEstado(BigDecimal id,String estado) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			
			if(estado != null) {
				sol.setEstado(estado);
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Estado actualizado");
				return resp;
			}else {
				resp.setCodigo(101);
				resp.setMensaje("El estado no puede ser null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	public GenericResponse updateComentarioTaller(BigDecimal id,String taller) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			
			if(sol.getEstado() != null) {
				sol.setComentariosTaller(taller);;
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Comentario taller actualizado");
				return resp;
			}else {
				resp.setCodigo(102);
				resp.setMensaje("El comentario viene null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	
	public GenericResponse updateComentarioAseguradora(BigDecimal id,String aseguradora) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			
			if(sol.getEstado() != null) {
				sol.setComentariosAseguradora(aseguradora);
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Comentario aseguradora actualizado");
				return resp;
			}else {
				resp.setCodigo(103);
				resp.setMensaje("El comentario viene null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	
	public GenericResponse updateFechaInicio(BigDecimal id,String fechainicio) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			LocalDateTime dateTime = LocalDateTime.parse(fechainicio);
			if(sol.getEstado() != null) {
				sol.setFechaInicio(dateTime);;
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Fecha Inicio Actualizada");
				return resp;
			}else {
				resp.setCodigo(104);
				resp.setMensaje("La fecha viene null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	public GenericResponse updateFechaFin(BigDecimal id,String fechaFin) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			LocalDateTime dateTime = LocalDateTime.parse(fechaFin);
			if(sol.getEstado() != null) {
				sol.setFechaInicio(dateTime);;
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Fecha Fin Actualizada");
				return resp;
			}else {
				resp.setCodigo(104);
				resp.setMensaje("La fecha viene null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	
	public GenericResponse updateComentarioProveedor(BigDecimal id,String proveedor) {
		GenericResponse resp = new GenericResponse();
		if(solRepository.existsById(id)) {
			Solicitud sol = solRepository.findById(id).orElse(new Solicitud());
			
			if(sol.getEstado() != null) {
				sol.setComentariosProveedores(proveedor);
				solRepository.save(sol);
				resp.setCodigo(500);
				resp.setMensaje("Comentario proveedor actualizado");
				return resp;
			}else {
				resp.setCodigo(104);
				resp.setMensaje("El comentario viene null");
				return resp;
			}
		}else
			resp.setCodigo(100);
			resp.setMensaje("No existe esa solicitud");
			return resp;
			
	}
	
	public Iterable<Solicitud> getByEstado(String estado){
		return solRepository.findByEstado(estado);	
	}
	
	
	
	public RepuestoXSolicitud saveRepuestoxSolicitud(RepuestoXSolicitudRequest rsr) {
		Repuestos r = this.getRepuesto(rsr.getIdRepuesto());
		Solicitud s = this.getSolicitudById(rsr.getId());
		if(s == null || r == null) {
			return new RepuestoXSolicitud();
		}
		RepuestoXSolicitud rxs = new RepuestoXSolicitud();
		RepuestoXSolicitudKeys keys = new RepuestoXSolicitudKeys();
		keys.setIdrepuesto(rsr.getIdRepuesto());
		keys.setIdsolicitud(s.getId());
		rxs.setRepuesto(r);
		rxs.setSolicitud(s);
		rxs.setId(keys);
		rxs.setAplica(rsr.isAplica());
		rxs.setEstado(rsr.getEstado());
		return rSRepository.save(rxs);
		
	}
	
	public RepuestoXSolicitud updateRepuestoxSolicitud(RepuestoXSolicitudRequest rsr) {
		Solicitud s = this.getSolicitudById(rsr.getId());
		if(s == null) {
			return new RepuestoXSolicitud();
		}
		RepuestoXSolicitud rxs = new RepuestoXSolicitud();
		RepuestoXSolicitudKeys keys = new RepuestoXSolicitudKeys();
		keys.setIdrepuesto(rsr.getIdRepuesto());
		keys.setIdsolicitud(s.getId());
		rxs = this.getRepuestoXSolicitudById(keys);
		if(rxs == null) {
			return new RepuestoXSolicitud();
		}
		if(rsr.getEstado() != null) {
			rxs.setEstado(rsr.getEstado());
		}
		return rSRepository.save(rxs);
	}
	
	public RepuestoXSolicitud changeAplicaRepuestoxSolicitud(RepuestoXSolicitudRequest rsr) {
		Solicitud s = this.getSolicitudById(rsr.getId());
		if(s == null) {
			return new RepuestoXSolicitud();
		}
		RepuestoXSolicitud rxs = new RepuestoXSolicitud();
		RepuestoXSolicitudKeys keys = new RepuestoXSolicitudKeys();
		keys.setIdrepuesto(rsr.getIdRepuesto());
		keys.setIdsolicitud(s.getId());
		rxs = this.getRepuestoXSolicitudById(keys);
		if(rxs == null) {
			return new RepuestoXSolicitud();
		}
		rxs.setAplica(rsr.isAplica());
		return rSRepository.save(rxs);
	}
		
		public FotosXSolicitud saveFotoXSolicitud(FilesRequest file) throws Exception {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileUploadException("El siguiente archivo tiene caracteres invalidos " + fileName);
	            }
	            Solicitud sol = this.getOneSolicitudByCode(file.getCodigoSolicitud());
	            
	            FotosXSolicitud dbFile = new FotosXSolicitud();
	            dbFile.setFoto(file.getBytes());
	            dbFile.setIdSolicitud(sol);

	            return fSRepository.save(dbFile);
	        } catch (Exception ex) {
	            throw new Exception("No se puede guardar el archivo " + fileName + ". Intente nuevamente! Ex:", ex);
	        }
	    }

	    public FotosXSolicitud getFile(BigDecimal fileId) {
	        return fSRepository.findById(fileId).orElse(null);
	    }
	    
	    public Repuestos getRepuesto(BigDecimal id) {
	        return rRepository.findById(id).orElse(null);
	    }
		
	    public RepuestoXSolicitud getRepuestoXSolicitudById(RepuestoXSolicitudKeys id) {
	        return rSRepository.findById(id).orElse(null);
	    }
	    
	    public Iterable<RepuestoXSolicitud> getRepuestoXSolicitudByIdRepuesto(BigDecimal id) {
	        return rSRepository.findByRepuesto(id);
	    }
	    
	    public Iterable<RepuestoXSolicitud> getRepuestoXSolicitudByIdSolicitud(BigDecimal id) {
	        return rSRepository.findBySolicitud_id(id);
	    }
	    
	    public Solicitud getSolicitudById(BigDecimal id) {
	    	return solRepository.findById(id).orElse(null);
	    }
	

		public FotosXSolicitud saveFotoXSolicitud2(MultipartFile file,BigDecimal id) throws Exception {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileUploadException("El siguiente archivo tiene caracteres invalidos " + fileName);
	            }
	            Solicitud sol = this.getSolicitudById(id);
	            
	            FotosXSolicitud dbFile = new FotosXSolicitud();
	            dbFile.setFoto(file.getBytes());
	            dbFile.setIdSolicitud(sol);

	            return fSRepository.save(dbFile);
	        } catch (Exception ex) {
	            throw new Exception("No se puede guardar el archivo " + fileName + ". Intente nuevamente! Ex:", ex);
	        }
	    }

	    
	    
}
