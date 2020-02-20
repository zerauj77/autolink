package com.autolink.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fotoxsolicitud")
public class FotosXSolicitud implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private byte[] foto;
	private Solicitud idSolicitud;
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 11, scale = 0)	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	
	@Lob
	@Column(name = "foto")	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	@ManyToOne
	@JoinColumn(name = "idsolicitud",insertable=true, updatable=true)
	public Solicitud getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Solicitud idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	
	
	
}
