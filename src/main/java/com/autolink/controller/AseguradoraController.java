package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.AseguradoraRepository;
import com.autolink.model.Aseguradora;
import com.autolink.model.Taller;

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
	
	public Aseguradora changeEstado(String aseguradora, boolean estado){
		Aseguradora ase = this.aseguradoraRepository.findByNombre(aseguradora);
		ase.setEstado(estado);
		return aseguradoraRepository.save(ase);
		
	}


}
