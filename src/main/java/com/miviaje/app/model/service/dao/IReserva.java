package com.miviaje.app.model.service.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.miviaje.app.model.Reserva;

public interface IReserva extends CrudRepository<Reserva, Integer>{
	
	
	@Query("select r from Reserva r where r.numeroDocumento = :numeroDocumento and r.token = :token and r.tipoDocumento = :tipoDocumento")
	public Reserva findReservaByTokenDocumento(@Param("numeroDocumento") String numeroDocumento, @Param("token") String token, @Param("tipoDocumento") String tipoDocumento);
	
	
	@Query("SELECT r.token FROM Reserva r WHERE r.idReservas = :idReserva")
	public String findTokenByID(@Param("idReserva") int idReserva );
	
	@Query("SELECT r.token FROM Reserva r WHERE r.numeroDocumento = :numeroDocumento")
	public String findTokenByDocumento(@Param("numeroDocumento") String numeroDocumento);
	
	
	// Consulta para recuperar el token cuando se olvida
	@Query("SELECT r.token FROM Reserva r WHERE r.tipoDocumento = :tipoDocumento AND r. numeroDocumento = :numeroDocumento AND r.correoPersona = :correoPersona")
	public String recuperarToken(@Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("correoPersona") String correoPersona);
	
	
}
