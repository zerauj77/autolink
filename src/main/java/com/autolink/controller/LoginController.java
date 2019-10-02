package com.autolink.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.TipoUsuarioRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;
import com.autolink.responses.LoginResponse;



public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TipoUsuarioRepository tpRepository;
	
	
	public LoginResponse validate(String usuario,String contraseña) {
		LoginResponse res = new LoginResponse();
		try {
			
			Usuarios usu = usuarioRepository.findByUsuario(usuario);
			TipoUsuario tp;
			//Si no es null es por que existe el usuario
			if(usu != null) {
				if(usu.getContra().equals(contraseña)) {
					res.setMensaje("Ingreso exitoso");
					res.setNombre(usu.getNombre());
					res.setUser(usuario);
					tp = usu.getTipo();
					res.setIdTipo(tp.getId());
					res.setTipo(tp.getNombre());
				}else
					res.setMensaje("Contraseña invalida");
			}else {
				res.setMensaje("Usuario no existe");
			}
			return res;
		}catch(Exception ex) {
			res.setMensaje(ex.getMessage());
			return res;
		}
		
	}
}
