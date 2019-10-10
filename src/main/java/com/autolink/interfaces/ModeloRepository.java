package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Marca;
import com.autolink.model.Modelo;

public interface ModeloRepository extends CrudRepository<Modelo, BigDecimal> {

	public Modelo findByNombre(String nombre);
	public Iterable<Modelo> findByMarca(Marca idTipo);

}
