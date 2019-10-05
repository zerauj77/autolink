package com.autolink.rest;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autolink.controller.LoginController;
import com.autolink.controller.TallerController;
import com.autolink.controller.UsuarioController;
import com.autolink.model.Taller;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;
import com.autolink.responses.GenericResponse;
import com.autolink.responses.LoginResponse;

@RestController
@RequestMapping(value="/rest")
public class RestApi {
	
	@Autowired
	LoginController lgc;
	
	@Autowired
	UsuarioController userc;
	
	@Autowired
	TallerController tallerc;
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public LoginResponse getConfiguration(@RequestParam String user, @RequestParam String pass) {
			return lgc.validate(user,pass);	
	}
	
	@RequestMapping(value = {"/recover"}, method = RequestMethod.GET)
	public GenericResponse recoverUser(@RequestParam String user) throws MessagingException, IOException {
			return lgc.recuperarPassword(user);
	}
	
	@RequestMapping(value = {"/recove2r"}, method = RequestMethod.GET)
	public GenericResponse recoverUser() throws MessagingException, IOException {
			return lgc.recuperarPassword("PattyB");
	}
	
	
//	----------------------- Metodos User -------------------------------------
	@RequestMapping(value = {"usuario/all"}, method = RequestMethod.GET)
	public Iterable<Usuarios> getAllUsers() {
			return userc.getAllUsers();
	}
	
	@RequestMapping(value = {"usuarioType/all"}, method = RequestMethod.GET)
	public Iterable<TipoUsuario> getUsersByTipo() {
			return userc.getAllTipoUsuario();
	}
	
	
	
	
	@RequestMapping(value = {"usuario/save"}, method = RequestMethod.POST)
	public Usuarios saveUser(@RequestBody Usuarios usu) {
			return userc.save(usu);
	}
	
	@RequestMapping(value = {"usuario/save2"}, method = RequestMethod.GET)
	public Usuarios saveUser() {
			return userc.save();
	}
	

	@RequestMapping(value = {"taller/all"}, method = RequestMethod.GET)
	public Iterable<Taller> getAllTalleres() {
			return tallerc.getAllTalleres();
	}
	
	@RequestMapping(value = {"taller/save"}, method = RequestMethod.POST)
	public Taller save(@RequestBody Taller taller) {
			return tallerc.save(taller);
	}
	

}
