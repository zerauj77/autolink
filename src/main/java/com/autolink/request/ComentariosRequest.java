package com.autolink.request;

import java.math.BigDecimal;

public class ComentariosRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String comentario;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	


}
