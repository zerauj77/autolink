package com.autolink.request;

import java.math.BigDecimal;

public class PreguntasRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idPregunta;
	private BigDecimal idUsuario;
	private String respuesta;
	public BigDecimal getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(BigDecimal idPregunta) {
		this.idPregunta = idPregunta;
	}
	public BigDecimal getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	


}
