package com.miviaje.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.miviaje.app.model.Contacto;
import com.miviaje.app.model.Hotel;
import com.miviaje.app.model.Reserva;
import com.miviaje.app.model.service.IReservacionService;
import com.miviaje.app.model.service.ReservacionService;

@RestController
@RequestMapping("/api")
public class ReservacionController {

	@Autowired
	private IReservacionService reservacionService;

	/*
	 * 
	 * 
	 * 
	 * Metodos CRUD de hotel
	 * 
	 * 
	 */

	@GetMapping("/hoteles")
	public List<Hotel> getHoteles() {
		return reservacionService.getHoteles();
	}

	@GetMapping("/hoteles/{id}")
	public Hotel getHotelXId(@PathVariable int id) {
		Hotel hotel = null;
		try {
			hotel = reservacionService.getHotelXId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (hotel == null) {
			System.out.println("El hotel ID: " + id + " no existe en la base de datos");

		}
		return hotel;
	}

	@PostMapping("/hoteles")
	// anotación @Valid no funciona
	public String crearHotel(@RequestBody Hotel hotel) {
		String message = "";
		Hotel hotelN = null;
		try {
			hotelN = reservacionService.crearHotel(hotel);
			message = "Hotel agregado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		// reservacionService.crearHotel(hotel);
		return message;
	}

	@DeleteMapping("/hoteles/{id}")
	public String eliminarHotel(@PathVariable int id) {
		String message = "";
		try {
			reservacionService.eliminarHotel(id);
			message = "Hotel eliminado con exito";
		} catch (DataAccessException e) {
			message = e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
		}
		return message;
	}

	@GetMapping("/hoteles/ciudad/{ciudad}")
	public List<Hotel> getHotelByCiudad(@PathVariable String ciudad) {
		return reservacionService.getHotelByCiudad(ciudad);
	}

	@GetMapping("/top")
	public Map<Integer, Integer> topHoteles() {
		return reservacionService.topHoteles();
	}

	/*
	 * 
	 * Metodos CRUD de Reservas
	 * 
	 * 
	 */

	@PostMapping("/reservas")
	public String crearReserva(@RequestBody Reserva reserva) {
		String message = "No se pudo agendar la reserva";
		Reserva reservaN = null;
		try {
			reservaN = reservacionService.crearReserva(reserva);
			reservaN.getIdReservas();
			message = "Reserva agendada correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		return message;
	}

	// Obtiene todas las reservas
	@GetMapping("/reservas")
	public List<Reserva> getReservas() {
		return reservacionService.getReservas();
	}

	// Obtiene una reserva por su ID
	@GetMapping("/reservas/{id}")
	public Reserva getReservaXId(@PathVariable int id) {
		return reservacionService.getReservaXId(id);
	}

	// Obtiene una reserva por el documento y el token
	@GetMapping("/reservas/cedulatoken")
	public Reserva getReservaByTokenDocumento(@RequestParam String numeroDocumento, @RequestParam String token,
			@RequestParam String tipoDocumento) {
		return reservacionService.getReservaByTokenDocumento(numeroDocumento, token, tipoDocumento);
	}

	// Obtiene un token de una reserva por su id
	@GetMapping("/reservas/token/{id}")
	public String findTokenByID(@PathVariable int id) {
		return reservacionService.findTokenByID(id);
	};

	// Obtiene un token por el documento
	@GetMapping("/reservas/documento/{numeroDocumento}")
	public String findTokenByDocumento(@PathVariable String numeroDocumento) {
		// HashMap<String, String> map = new HashMap<>();
		// map.put("token", reservacionService.findTokenByDocumento(numeroDocumento));

//		return map;

		return reservacionService.findTokenByDocumento(numeroDocumento);

	}
	
	
	// Recuperar el token cuando se olvida
	@GetMapping("/reservas/recuperarToken")
	public String recuperarToken(String tipoDocumento, String numeroDocumento, String correoPersona) {
		return reservacionService.recuperarToken(tipoDocumento, numeroDocumento, correoPersona);
	}

	// Actualiza una reserva
	@PutMapping("/reservas")
	public String actualizarReserva(@RequestBody Reserva reserva) {
		String message = "No se pudo actualizar la reserva";
		try {
			reservacionService.actualizarReserva(reserva);
			message = "Reserva actualizada";

		} catch (DataAccessException e) {
			message = e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
		}

		return message;
	}

	// Elimina una reserva
	@DeleteMapping("/reservas/{id}")
	public String eliminarReservas(@PathVariable int id) {
		String message = "";
		try {
			reservacionService.eliminarReserva(id);
			message = "Reserva eliminada con exito";
		} catch (DataAccessException e) {
			message = e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
		}
		return message;
	}

	/*
	 * 
	 * Metodos CRUD de Contacto
	 * 
	 * 
	 */

	@GetMapping("/contactos")
	public List<Contacto> getContactos() {
		return reservacionService.getContactos();
	}

	@GetMapping("/contactos/{id}")
	public Contacto getContactoXId(@PathVariable int id) {
		Contacto contacto = null;
		try {
			contacto = reservacionService.getContactoXId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (contacto == null) {
			System.out.println("El contacto ID: " + id + " no existe en la base de datos");

		}
		return contacto;
	}

	@PostMapping("/contactos")
	// anotación @Valid no funciona
	public String crearContacto(@RequestBody Contacto contacto) {
		String message = "";
		Contacto contactoNuevo = null;
		try {
			contactoNuevo = reservacionService.crearContacto(contacto);
			message = "Contacto agregado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	@DeleteMapping("/contactos/{id}")
	public String eliminarContacto(@PathVariable int id) {
		String message = "";
		try {
			reservacionService.eliminarContacto(id);
			message = "Contacto eliminado con exito";
		} catch (DataAccessException e) {
			message = e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
		}
		return message;
	}

}
