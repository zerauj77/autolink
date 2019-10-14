package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.MarcaRepository;
import com.autolink.interfaces.ModeloRepository;
import com.autolink.model.Marca;
import com.autolink.model.Modelo;

public class AutoController {
	@Autowired
	ModeloRepository modeloRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	public Iterable<Marca> getAllMarcas() {
		return marcaRepository.findAll();
	}
	
	public Iterable<Modelo> getAllModelos() {
		return modeloRepository.findAll();
	}
	
	public Marca getByMarcaName(String nombre){
		return marcaRepository.findByNombre(nombre);
	}
	
	public Modelo getByModeloName(String nombre){
		return modeloRepository.findByNombre(nombre);
	}
	
	public Marca saveMarca(Marca usu){
		return marcaRepository.save(usu);
	}
	
	public Modelo saveModelo(Modelo usu){
		return modeloRepository.save(usu);
	}
	
	public Marca changeEstadoMarca(String marca, boolean estado){
		Marca usu = marcaRepository.findByNombre(marca);
		usu.setEstado(estado);
		return marcaRepository.save(usu);
		
	}
	
	public Modelo changeEstadoModelo(String modelo, boolean estado){
		Modelo model = modeloRepository.findByNombre(modelo);
		model.setEstado(estado);
		return modeloRepository.save(model);
		
	}
	
	public Modelo updateModelo(Modelo modelo){
		Modelo model = modeloRepository.findByNombre(modelo.getNombre());
		if(modelo.getMarca() != null) {
			model.setMarca(modelo.getMarca());
		}
		return modeloRepository.save(model);
	}
	
		


}
