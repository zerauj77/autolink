package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Taller;
import com.autolink.model.Usuarios;

public interface TallerRepository extends CrudRepository<Taller, BigDecimal> {

	public Taller findByNombre(String nombre);
	public Taller findByUsuario(Usuarios usuario);	
	
}
