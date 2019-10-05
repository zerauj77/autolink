package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Taller;

public interface TallerRepository extends CrudRepository<Taller, BigDecimal> {

	public Taller findByNombre(String nombre);
	
}
