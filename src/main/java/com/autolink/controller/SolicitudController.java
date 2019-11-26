package com.autolink.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
		return rSRepository.findBySolicitud(id);
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
	
	public Iterable<Solicitud> getByEstado(String estado){
		return solRepository.findByEstado(estado);	
	}
	
	
	public RepuestoXSolicitud saveRepuestoxSolicitud(RepuestoXSolicitudRequest rsr) {
		Repuestos r = this.getRepuesto(rsr.getIdRepuesto());
		Solicitud s = this.getOneSolicitudByCode(rsr.getCodigoSolicitud());
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
		Solicitud s = this.getOneSolicitudByCode(rsr.getCodigoSolicitud());
		RepuestoXSolicitud rxs = new RepuestoXSolicitud();
		RepuestoXSolicitudKeys keys = new RepuestoXSolicitudKeys();
		keys.setIdrepuesto(rsr.getIdRepuesto());
		keys.setIdsolicitud(s.getId());
		rxs = this.getRepuestoXSolicitudById(keys);
		if(rsr.getEstado() != null) {
			rxs.setEstado(rsr.getEstado());
		}
		return rSRepository.save(rxs);
	}
	
	public RepuestoXSolicitud changeAplicaRepuestoxSolicitud(RepuestoXSolicitudRequest rsr) {
		Solicitud s = this.getOneSolicitudByCode(rsr.getCodigoSolicitud());
		RepuestoXSolicitud rxs = new RepuestoXSolicitud();
		RepuestoXSolicitudKeys keys = new RepuestoXSolicitudKeys();
		keys.setIdrepuesto(rsr.getIdRepuesto());
		keys.setIdsolicitud(s.getId());
		rxs = this.getRepuestoXSolicitudById(keys);
		rxs.setAplica(rsr.isAplica());
		return rSRepository.save(rxs);
	}
		
		public FotosXSolicitud saveFotoXSolicitud(FilesRequest file) throws Exception {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileUploadException("Sorry! Filename contains invalid path sequence " + fileName);
	            }
	            Solicitud sol = this.getOneSolicitudByCode(file.getCodigoSolicitud());
	            
	            FotosXSolicitud dbFile = new FotosXSolicitud();
	            dbFile.setFoto(file.getBytes());
	            dbFile.setIdSolicitud(sol);

	            return fSRepository.save(dbFile);
	        } catch (Exception ex) {
	            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
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
	        return rSRepository.findBySolicitud(id);
	    }
	
	
}
