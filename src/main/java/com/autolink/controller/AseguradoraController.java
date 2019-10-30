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
	
	public Aseguradora changeEstado(String aseguradora, boolean estado){
		Aseguradora ase = this.aseguradoraRepository.findByNombre(aseguradora);
		ase.setEstado(estado);
		return aseguradoraRepository.save(ase);
		
	}
	
	public Aseguradora update(Aseguradora aseguradora){
		Aseguradora ase = this.aseguradoraRepository.findByNombre(aseguradora.getNombre());
		if(aseguradora.getIva() != null) {
			ase.setIva(aseguradora.getIva());
		}
		if(aseguradora.getNit() != null) {
			ase.setNit(aseguradora.getNit());
		}
		if(aseguradora.getRazonsocial() != null) {
			ase.setRazonsocial(aseguradora.getRazonsocial());
		}
		if(aseguradora.getCargo() != null) {
			ase.setCargo(aseguradora.getCargo());
		}
		if(aseguradora.getUsuario() != null) {
			ase.setUsuario(aseguradora.getUsuario());
		}
		return aseguradoraRepository.save(ase);
	}


}
