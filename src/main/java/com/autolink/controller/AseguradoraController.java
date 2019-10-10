package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.AseguradoraRepository;
import com.autolink.model.Aseguradora;

public class AseguradoraController {

	@Autowired
	AseguradoraRepository aseguradoraRepository;
	
	public Iterable<Aseguradora> getAllAseguradoraes() {
		return aseguradoraRepository.findAll();
	}
	
	public Aseguradora save(Aseguradora usu){
		return aseguradoraRepository.save(usu);
	}
	
	public Aseguradora findByaseguradora(String aseguradora){
		return aseguradoraRepository.findByNombre(aseguradora);
	}


}
