package com.autolink.controller;

import java.math.BigDecimal;

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
	
	public Marca getByMarcaById(BigDecimal id){
		return marcaRepository.findById(id).orElse(null);
	}
	
	public Modelo getByModeloName(String nombre){
		return modeloRepository.findByNombre(nombre);
	}
	
	public Modelo getByModeloById(BigDecimal id){
		return modeloRepository.findById(id).orElse(null);
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
		Modelo model = modeloRepository.findById(modelo.getId()).orElse(null);
		if(model != null) {
			if(modelo.getMarca() != null) {
				model.setMarca(modelo.getMarca());
			}
			if(modelo.getNombre() !=null) {
				model.setNombre(modelo.getNombre());
			}
			return modeloRepository.save(model);
		}else {
			return null;
		}
	}
	
		


}
