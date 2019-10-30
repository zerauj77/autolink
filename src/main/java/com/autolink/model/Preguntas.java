package com.autolink.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preguntascontra")
public class Preguntas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String pregunta;
	
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	

}
