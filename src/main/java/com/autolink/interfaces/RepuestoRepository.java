package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Repuestos;

public interface RepuestoRepository extends CrudRepository<Repuestos, BigDecimal> {

	public Repuestos findByNombre(String nombre);

}
