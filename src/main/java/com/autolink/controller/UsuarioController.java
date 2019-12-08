package com.autolink.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.PreguntaRepository;
import com.autolink.interfaces.TipoUsuarioRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.interfaces.UsuarioXPreguntaRepository;
import com.autolink.model.Preguntas;
import com.autolink.model.PreguntasXUsuario;
import com.autolink.model.PreguntasXUsuarioKeys;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;


public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TipoUsuarioRepository tpRepository;
	
	@Autowired
	UsuarioXPreguntaRepository upRepository;
	
	@Autowired
	PreguntaRepository pRepository;
	
	public Iterable<Usuarios> getAllUsers() {
		return usuarioRepository.findAll();
	}
	
	public Usuarios getOneUser(String usuario){
		return usuarioRepository.findByNombre(usuario);
	}
	
	public Usuarios getOneUserByUser(String user){
		return usuarioRepository.findByUsuario(user);
	}
	
	public Usuarios save(Usuarios usu){
		return usuarioRepository.save(usu);
	}
	
	public Usuarios save(){
			Usuarios usu = new Usuarios();
			Date date = new Date();
			System.out.println(date.toString());
			usu.setNombre("prueba1");
			usu.setContra("prueba3");
			usu.setUsuario("prueba4");
			TipoUsuario tp = new TipoUsuario();
			tp.setId(BigDecimal.ONE);
			tp.setNombre("Admin");
			usu.setTipo(tp);
			usu.setUsuariocrea("michu");
			usu.setFechacreacion(date);
			usu.setEstado(true);
		return usuarioRepository.save(usu);
	}
	
	public Iterable<Usuarios> getUsuariosXTipo(String nombreTipo) {
		TipoUsuario tipo = this.getOneTipoUsuario(nombreTipo);
		
		return this.usuarioRepository.findByTipo(tipo);
	}

	
	public Usuarios update(Usuarios usuario){
		Usuarios usu = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(usuario.getContra() != null) {
			usu.setContra(usuario.getContra());
		}
		if(usuario.getNombre() != null) {
			usu.setNombre(usuario.getNombre());
		}
		if(usuario.getUsuariocrea() != null) {
			usu.setUsuariocrea(usuario.getUsuariocrea());
		}
		if(usuario.getTipo() != null) {
			usu.setTipo(usuario.getTipo());
		}
		return usuarioRepository.save(usu);
	}
	
	public Usuarios changeEstado(String usuario, boolean estado){
		Usuarios usu = usuarioRepository.findByUsuario(usuario);
		usu.setEstado(estado);
		return usuarioRepository.save(usu);
		
	}
	
	public Iterable<Preguntas> allPreguntas() {
		return pRepository.findAll();
	}
	
	public TipoUsuario getOneTipoUsuario(String name) {
		return tpRepository.findByNombre(name);
	}
	
	public Iterable<TipoUsuario> getAllTipoUsuario() {
		return tpRepository.findAll();
	}
	
	public TipoUsuario getOneTipoUsuarioById(BigDecimal id) {
		return tpRepository.findById(id).orElse(null);
	}
	
	public Iterable<PreguntasXUsuario> getAllPreguntaXUsuario() {
		return upRepository.findAll();
	}
	
	public Iterable<PreguntasXUsuario> getAllPreguntaXUsuario_ByUsuario(BigDecimal id) {
		return upRepository.findByUsuarios_Id(id);
	}
	
	public PreguntasXUsuario savePreguntaXUsuario(BigDecimal idPregunta, BigDecimal idUsuario, String respuesta) {
		Preguntas pre = this.preguntaById(idPregunta);
		Usuarios usu = this.usuarioById(idUsuario);
		PreguntasXUsuario pxu = new PreguntasXUsuario();
		PreguntasXUsuarioKeys pxuk = new PreguntasXUsuarioKeys();
		pxuk.setIdPregunta(idPregunta);
		pxuk.setIdUsuarios(idUsuario);
		pxu.setId(pxuk);
		pxu.setPreguntas(pre);
		pxu.setRespuesta(respuesta);
		pxu.setUsuarios(usu);
		return upRepository.save(pxu);
		
		
	}

	public Preguntas preguntaById(BigDecimal id) {
		return pRepository.findById(id).orElse(null);
	}
	
	public Usuarios usuarioById(BigDecimal id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
}
