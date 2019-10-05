package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.TipoUsuarioRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;


public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TipoUsuarioRepository tpRepository;
	
	public Iterable<Usuarios> getAllUsers() {
		return usuarioRepository.findAll();
	}
	
	public Usuarios getOneUser(String usuario){
		return usuarioRepository.findByNombre(usuario);
	}
	
	public Usuarios save(Usuarios usu){
		return usuarioRepository.save(usu);
	}
	
	public Usuarios save(){
		Usuarios usu = new Usuarios();
		usu.setNombre("prueba1");
		usu.setEmail("prueba2");
		usu.setContra("prueba3");
		usu.setUsuario("prueba4");
		TipoUsuario tp = new TipoUsuario();
		tp.setId(BigDecimal.ONE);
		tp.setNombre("Admin");
		usu.setTipo(tp);
		
		return usuarioRepository.save(usu);
	}
	
	public TipoUsuario getOneTipoUsuario(String name) {
		return tpRepository.findByNombre(name);
	}
	
	public Iterable<TipoUsuario> getAllTipoUsuario() {
		return tpRepository.findAll();
	}
	
	
}
