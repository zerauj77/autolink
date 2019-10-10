package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.MarcaRepository;
import com.autolink.interfaces.ModeloRepository;
import com.autolink.model.Marca;
import com.autolink.model.Modelo;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;
import com.autolink.request.UsuarioRequest;

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
	
		


}
