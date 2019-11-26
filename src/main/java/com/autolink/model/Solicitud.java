package com.autolink.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud")
public class Solicitud implements java.io.Serializable {

		private static final long serialVersionUID = 1L;
		BigDecimal id;
		Taller idTaller;
		Aseguradora idAseguradora;
		Marca idMarca;
		Usuarios idUsuario;
		String anioCarro;
		String tipoVehiculo;
		String placa;
		String chasis;
		String motor;
		String poliza;
		String siniestro;
		String nombreAsegurado;
		String codigoSolicitud;
		String estado;
		String comentariosTaller;
		String comentariosAseguradora;
		String comentariosAprovadores;
		Date fechaInicio;
		Date fechaFin;
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", unique = true, nullable = false, precision = 11, scale = 0)
		public BigDecimal getId() {
			return id;
		}
		
		public void setId(BigDecimal id) {
			this.id = id;
		}
		
		@ManyToOne
		@JoinColumn(name = "idtaller",insertable=true, updatable=true)
		public Taller getIdTaller() {
			return idTaller;
		}
		
		public void setIdTaller(Taller idTaller) {
			this.idTaller = idTaller;
		}
		
		@ManyToOne
		@JoinColumn(name = "idaseguradora",insertable=true, updatable=true)
		public Aseguradora getIdAseguradora() {
			return idAseguradora;
		}
		
		public void setIdAseguradora(Aseguradora idAseguradora) {
			this.idAseguradora = idAseguradora;
		}
		
		@ManyToOne
		@JoinColumn(name = "idmarca",insertable=true, updatable=true)
		public Marca getIdMarca() {
			return idMarca;
		}
		
		public void setIdMarca(Marca idMarca) {
			this.idMarca = idMarca;
		}
		
		@ManyToOne
		@JoinColumn(name = "idusuario",insertable=true, updatable=true)
		public Usuarios getIdUsuario() {
			return idUsuario;
		}
		
		public void setIdUsuario(Usuarios idUsuario) {
			this.idUsuario = idUsuario;
		}
		
		@Column(name = "aniocarro", length = 50,unique = true)
		public String getAnioCarro() {
			return anioCarro;
		}
		
		public void setAnioCarro(String anioCarro) {
			this.anioCarro = anioCarro;
		}
		
		@Column(name = "tipovehiculo", length = 50,unique = true)
		public String getTipoVehiculo() {
			return tipoVehiculo;
		}
		
		
		public void setTipoVehiculo(String tipoVehiculo) {
			this.tipoVehiculo = tipoVehiculo;
		}
		
		@Column(name = "placa", length = 50,unique = true)
		public String getPlaca() {
			return placa;
		}
		
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		
		@Column(name = "chasis", length = 50,unique = true)
		public String getChasis() {
			return chasis;
		}
		
		public void setChasis(String chasis) {
			this.chasis = chasis;
		}
		
		@Column(name = "motor", length = 50,unique = true)
		public String getMotor() {
			return motor;
		}
		
		public void setMotor(String motor) {
			this.motor = motor;
		}
		
		@Column(name = "poliza", length = 50,unique = true)
		public String getPoliza() {
			return poliza;
		}
		
		public void setPoliza(String poliza) {
			this.poliza = poliza;
		}
		
		@Column(name = "siniestro", length = 50,unique = true)
		public String getSiniestro() {
			return siniestro;
		}
		
		public void setSiniestro(String siniestro) {
			this.siniestro = siniestro;
		}
		
		@Column(name = "nombreasegurado", length = 50,unique = true)
		public String getNombreAsegurado() {
			return nombreAsegurado;
		}
		
		public void setNombreAsegurado(String nombreAsegurado) {
			this.nombreAsegurado = nombreAsegurado;
		}
		
		@Column(name = "codigosolicitud", length = 50,unique = true)
		public String getCodigoSolicitud() {
			return codigoSolicitud;
		}
		
		public void setCodigoSolicitud(String codigoSolicitud) {
			this.codigoSolicitud = codigoSolicitud;
		}
		
		@Column(name = "estado", length = 50,unique = true)
		public String getEstado() {
			return estado;
		}
		
		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		@Column(name = "comentariostaller", length = 10000,unique = true)
		public String getComentariosTaller() {
			return comentariosTaller;
		}
		
		public void setComentariosTaller(String comentariosTaller) {
			this.comentariosTaller = comentariosTaller;
		}
		
		@Column(name = "comentariosaseguradora", length = 10000,unique = true)
		public String getComentariosAseguradora() {
			return comentariosAseguradora;
		}
		
		public void setComentariosAseguradora(String comentariosAseguradora) {
			this.comentariosAseguradora = comentariosAseguradora;
		}
		
		@Column(name = "comentariosaprovadores", length = 10000,unique = true)
		public String getComentariosAprovadores() {
			return comentariosAprovadores;
		}
		
		public void setComentariosAprovadores(String comentariosAprovadores) {
			this.comentariosAprovadores = comentariosAprovadores;
		}
		
		@Column(name = "fechainicio",unique = true)
		public Date getFechaInicio() {
			return fechaInicio;
		}
		
		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		
		@Column(name = "fechafin",unique = true)
		public Date getFechaFin() {
			return fechaFin;
		}
		
		public void setFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
		}
		
		
		
}
