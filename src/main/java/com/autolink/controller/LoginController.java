package com.autolink.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.autolink.interfaces.TipoUsuarioRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;
import com.autolink.responses.GenericResponse;
import com.autolink.responses.LoginResponse;



public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TipoUsuarioRepository tpRepository;
	@Autowired
    private JavaMailSender javaMailSender;
	
	
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
	
	public GenericResponse recuperarPassword(String usuario) throws MessagingException, IOException {
		try {
			System.out.println("el correo es" + usuario);
			this.sendEmailWithAttachment(usuario);
			GenericResponse res = new GenericResponse();
			res.setCodigo(200);
			res.setMensaje("Correo enviado con exito");
			return res;
		}catch(Exception ex) {
			throw ex;
		}	
	}
	
	void sendEmailWithAttachment(String correo) throws MessagingException, IOException {
		try {
			
        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
        helper.setTo(correo);

        helper.setSubject("Reinicio de contraseña Autolink");

        // true = text/html
        helper.setText("<h1>haga click en el siguiente url</h1>", true);
        helper.setText("<a href='http://localhost:4200/resetContrasena'>http://localhost:4200/resetContrasena</a>");
       

        javaMailSender.send(msg);
		}catch(Exception ex) {
			throw ex;
		}
    }
}
