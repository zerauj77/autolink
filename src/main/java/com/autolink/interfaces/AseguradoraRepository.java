package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Aseguradora;

public interface AseguradoraRepository extends CrudRepository<Aseguradora, BigDecimal> {

	public Aseguradora findByNombre(String nombre);

}
