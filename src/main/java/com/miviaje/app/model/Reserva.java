package com.miviaje.app.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.miviaje.app.model.service.ReservacionService;

@Entity
@Table(name = "reservas")
public class Reserva {

	@Id
	@Column(name = "id_reservas")
	private int idReservas;
	private String token=ReservacionService.generarToken(10);
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private int cantidadPersonas;
	private String nombrePersona;
	// @Column(name="apellido_persona")
	private String apellidoPersona;
	private String correoPersona;
	private String telefonoPersona;
	private String tipoDocumento;
	private String numeroDocumento;
	private int fkHotel;
	private int cantidadHabitaciones;
	

	public Reserva() {

	}

	public Reserva(int idReservas,String token,  LocalDate fechaInicial, LocalDate fechaFinal, int cantidadPersonas,
			String nombrePersona, String apellidoPersona, String correoPersona, String telefonoPersona,
			String tipoDocumento, String numeroDocumento, int fkHotel, int cantidadHabitaciones) {
		this.idReservas = idReservas;
		this.token = token;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.cantidadPersonas = cantidadPersonas;
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.correoPersona = correoPersona;
		this.telefonoPersona = telefonoPersona;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fkHotel=fkHotel;
		this.cantidadHabitaciones=cantidadHabitaciones;
	}


	public int getcantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setcantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public int getIdReservas() {
		return idReservas;
	}

	public void setIdReservas(int idReservas) {
		this.idReservas = idReservas;
	}

	public String getToken() {
		return token;
	}

	public LocalDate getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getCorreoPersona() {
		return correoPersona;
	}

	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}

	public String getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public int getFkHotel() {
		return fkHotel;
	}

	public void setFkHotel(int fkHotel) {
		this.fkHotel = fkHotel;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva{");
		sb.append("idReservas=").append(idReservas);
		sb.append(", token=").append(token);
		sb.append(", fechaInicial=").append(fechaInicial);
		sb.append(", fechaFinal=").append(fechaFinal);
		sb.append(", cantidadPersonas=").append(cantidadPersonas);
		sb.append(", nombrePersona=").append(nombrePersona);
		sb.append(", apellidoPersona=").append(apellidoPersona);
		sb.append(", correoPersona=").append(correoPersona);
		sb.append(", telefonoPersona=").append(telefonoPersona);
		sb.append(", tipoDocumento=").append(tipoDocumento);
		sb.append(", numeroDocumento=").append(numeroDocumento);
		sb.append('}');
		return sb.toString();
	}

	
}
