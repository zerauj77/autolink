package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Marca;

public interface MarcaRepository extends CrudRepository<Marca, BigDecimal> {

	public Marca findByNombre(String nombre);


}
