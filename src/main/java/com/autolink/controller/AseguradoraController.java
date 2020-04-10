package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.AseguradoraRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.Aseguradora;
import com.autolink.model.Usuarios;
import com.autolink.request.AseguradoraInsert;

public class AseguradoraController {

	@Autowired
	AseguradoraRepository aseguradoraRepository;
	
	@Autowired
	UsuarioRepository usuRepository;
	
	public Iterable<Aseguradora> getAllAseguradoraes() {
		return aseguradoraRepository.findAll();
	}
	
	public Aseguradora save(Aseguradora usu){
		return aseguradoraRepository.save(usu);
	}
	
	public Aseguradora findByaseguradora(String aseguradora){
		return aseguradoraRepository.findByNombre(aseguradora);
	}
	
	
	public Aseguradora findByaseguradoraById(BigDecimal id){
		return aseguradoraRepository.findById(id).orElse(null);
	}
	
	public Aseguradora changeEstado(String aseguradora, boolean estado){
		Aseguradora ase = this.aseguradoraRepository.findByNombre(aseguradora);
		ase.setEstado(estado);
		return aseguradoraRepository.save(ase);
		
	}
	
	public Aseguradora update(AseguradoraInsert aseguradora){
		Aseguradora ase = this.aseguradoraRepository.findById(aseguradora.getId()).orElse(null);
		if(ase !=null) {
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
				Usuarios usu = usuRepository.findByUsuario(aseguradora.getUsuario());
				if(usu != null) {
					ase.setUsuario(usu);
				}
				
			}
			if(aseguradora.getNombre() !=null) {
				ase.setNombre(aseguradora.getNombre());
			}
			return aseguradoraRepository.save(ase);
		}else {
			return null;
		}
	}


}
