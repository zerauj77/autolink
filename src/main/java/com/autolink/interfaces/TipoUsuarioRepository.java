package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, BigDecimal> {
	
	public TipoUsuario findByNombre(String nombre);
	

}
