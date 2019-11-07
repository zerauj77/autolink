package com.autolink.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preguntaxusuario")
public class PreguntasXUsuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreguntasXUsuarioKeys id;
	private Preguntas preguntas;
	private Usuarios usuarios;
	private String respuesta;
	
	@Id
	@EmbeddedId
	public PreguntasXUsuarioKeys getId() {
		return id;
	}
	public void setId(PreguntasXUsuarioKeys id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "idpregunta",insertable=false, updatable=false)
	public Preguntas getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}
	
	@ManyToOne
	@JoinColumn(name = "idusuario",insertable=false, updatable=false)
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	@Column(name = "respuesta")
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	

}
