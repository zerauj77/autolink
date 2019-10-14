package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, BigDecimal> {

	public Proveedor findByNombre(String nombre);


}
