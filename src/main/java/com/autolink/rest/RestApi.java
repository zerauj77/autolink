package com.autolink.rest;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autolink.controller.AseguradoraController;
import com.autolink.controller.AutoController;
import com.autolink.controller.LoginController;
import com.autolink.controller.TallerController;
import com.autolink.controller.UsuarioController;
import com.autolink.model.Aseguradora;
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
	
	@Autowired
	AseguradoraController asec;
	
	@Autowired
	AutoController autoc;
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse getConfiguration(@RequestParam String user, @RequestParam String pass) {
			return lgc.validate(user,pass);	
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/login2"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConfiguration2(@RequestParam String user, @RequestParam String pass) {
		return new ResponseEntity<>(lgc.validate(user,pass), HttpStatus.OK);	
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover"}, method = RequestMethod.GET)
	public GenericResponse recoverUser(@RequestParam String user) throws MessagingException, IOException {
			return lgc.recuperarPassword(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover2"}, method = RequestMethod.GET)
	public ResponseEntity<?> recoverUser() throws MessagingException, IOException {
			return new ResponseEntity<>(userc.getAllUsers(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover3"}, method = RequestMethod.GET)
	public BodyBuilder recoverUser2() throws MessagingException, IOException {
			return ResponseEntity.badRequest();
	}
	
	
//	----------------------- Metodos User -------------------------------------
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/all"}, method = RequestMethod.GET)
	public Iterable<Usuarios> getAllUsers() {
			return userc.getAllUsers();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuarioType/all"}, method = RequestMethod.GET)
	public Iterable<TipoUsuario> getUsersByTipo() {
			return userc.getAllTipoUsuario();
	}
	
	
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/save"}, method = RequestMethod.POST)
	public Usuarios saveUser(@RequestBody Usuarios usu) {
			return userc.save(usu);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/save2"}, method = RequestMethod.GET)
	public Usuarios saveUser() {
			return userc.save();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/update"}, method = RequestMethod.PUT)
	public Usuarios updateUser(@RequestBody Usuarios usu) {
			return userc.update(usu);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/all"}, method = RequestMethod.GET)
	public Iterable<Taller> getAllTalleres() {
			return tallerc.getAllTalleres();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/save"}, method = RequestMethod.POST)
	public Taller save(@RequestBody Taller taller) {
			return tallerc.save(taller);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"aseguradora/all"}, method = RequestMethod.GET)
	public Iterable<Aseguradora> getAllAseguradora() {
			return asec.getAllAseguradoraes();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"Aseguradora/save"}, method = RequestMethod.POST)
	public Aseguradora save(@RequestBody Aseguradora taller) {
			return asec.save(taller);
	}
	

}
