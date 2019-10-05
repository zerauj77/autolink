package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.TallerRepository;
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

}
