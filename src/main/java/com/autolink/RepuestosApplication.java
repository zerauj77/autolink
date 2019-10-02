package com.autolink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.autolink.controller.LoginController;
import com.autolink.controller.UsuarioController;

@SpringBootApplication
public class RepuestosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepuestosApplication.class, args);
	}
	
	@Bean
	public LoginController loginController(){
		return new LoginController();
	}
	
	@Bean
	public UsuarioController usuarioController(){
		return new UsuarioController();
	}

}
