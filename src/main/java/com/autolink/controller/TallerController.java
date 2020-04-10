package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.TallerRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.Taller;
import com.autolink.model.Usuarios;
import com.autolink.request.TallerInsert;

public class TallerController {
	@Autowired
	TallerRepository tallerRepository;
	
	@Autowired
	UsuarioController usuc;
	
	@Autowired
	UsuarioRepository usuRepository;
	
	public Iterable<Taller> getAllTalleres() {
		return tallerRepository.findAll();
	}
	
	public Taller save(Taller usu){
		return tallerRepository.save(usu);
	}
	
	public Taller findByTaller(String taller){
		return tallerRepository.findByNombre(taller);
	}
	
	public Taller findTallerById(BigDecimal id){
		return tallerRepository.findById(id).orElse(null);
	}
	
	public Taller findByUsuario(String usuario) throws Exception {
		Usuarios usu = usuc.getOneUserByUser(usuario);
		if(usu == null) {
			throw new Exception("No existe el Usuario seleccionado");
		}else {
			return tallerRepository.findByUsuario(usu);
		}
		
	}
	
	public Taller update(TallerInsert taller){
		Taller ta = this.tallerRepository.findById(taller.getId()).orElse(null);
		if(ta != null) {
			if(taller.getCargo() != null) {
				ta.setCargo(taller.getCargo());
			}
			if(taller.getRazonsocial() != null) {
				ta.setRazonsocial(taller.getRazonsocial());
			}
			if(taller.getTelefono() != null) {
				ta.setTelefono(taller.getTelefono());
			}
			if(taller.getUsuario() != null) {
				Usuarios usu = usuRepository.findByUsuario(taller.getUsuario());
				if(usu != null) {
					ta.setUsuario(usu);
				}
				
			}
			if(taller.getDireccion() != null) {
				ta.setDireccion(taller.getDireccion());
			}
			if(taller.getNombre() != null) {
				ta.setNombre(taller.getNombre());
			}
			
			return tallerRepository.save(ta);
		}else {
			return null;
		}
		
	}
	
	public Taller changeEstado(String taller, boolean estado){
		Taller ta = this.findByTaller(taller);
		ta.setEstado(estado);
		return tallerRepository.save(ta);
		
	}
	
	

}
