package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.TallerRepository;
import com.autolink.model.Aseguradora;
import com.autolink.model.Taller;
import com.autolink.model.Usuarios;

public class TallerController {
	@Autowired
	TallerRepository tallerRepository;
	
	public Iterable<Taller> getAllTalleres() {
		return tallerRepository.findAll();
	}
	
	public Taller save(Taller usu){
		return tallerRepository.save(usu);
	}
	
	public Taller findByTaller(String taller){
		return tallerRepository.findByNombre(taller);
	}
	
	public Taller update(Taller taller){
		Taller ta = this.tallerRepository.findByNombre(taller.getNombre());
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
			ta.setUsuario(taller.getUsuario());
		}
		return tallerRepository.save(ta);
	}
	
	public Taller changeEstado(String taller, boolean estado){
		Taller ta = this.findByTaller(taller);
		ta.setEstado(estado);
		return tallerRepository.save(ta);
		
	}

}
