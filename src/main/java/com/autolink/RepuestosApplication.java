package com.autolink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.autolink.controller.AseguradoraController;
import com.autolink.controller.AutoController;
import com.autolink.controller.LoginController;
import com.autolink.controller.ProveedorController;
import com.autolink.controller.RepuestoController;
import com.autolink.controller.TallerController;
import com.autolink.controller.UsuarioController;

@SpringBootApplication
public class RepuestosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepuestosApplication.class, args);
	}
	
	public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
                registry.addMapping("/recover2").allowedOrigins("http://localhost:9000");
            }
        };
    }
	
	@Bean
	public LoginController loginController(){
		return new LoginController();
	}
	
	@Bean
	public UsuarioController usuarioController(){
		return new UsuarioController();
	}
	
	@Bean
	public TallerController tallerController(){
		return new TallerController();
	}
	
	@Bean
	public AseguradoraController aseguradoraController(){
		return new AseguradoraController();
	}
	
	@Bean
	public AutoController autoController(){
		return new AutoController();
	}
	
	@Bean
	public ProveedorController proveedorController(){
		return new ProveedorController();
	}
	
	@Bean
	public RepuestoController repuestoController(){
		return new RepuestoController();
	}

}
