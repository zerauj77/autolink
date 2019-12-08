package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;

public interface UsuarioRepository extends CrudRepository<Usuarios, BigDecimal> {

	public Usuarios findByNombre(String nombre);
	public Usuarios findByUsuario(String usuario);
	public Iterable<Usuarios> findByTipo(TipoUsuario idTipo);


}
