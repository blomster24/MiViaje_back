package com.miviaje.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MiViajeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiViajeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Si tenemos varios controladores se duplica
				// "registry.addMapping("/mascotas").allowedOrigins("*");" y se cambia la ruta
				// addMapping
				// cambiamos * por el dominio o puerto para dar permiso en especifico
				registry.addMapping("/api/hoteles/ciudad/*").allowedOrigins("*");
				registry.addMapping("/api/hoteles").allowedOrigins("*"); 
                registry.addMapping("/api/hoteles/bogota").allowedOrigins("*"); 
                registry.addMapping("/api/reservas").allowedOrigins("*"); 
                registry.addMapping("/api/reservas/id").allowedOrigins("*"); 
                registry.addMapping("/api/reservas/id/*").allowedOrigins("*");
                registry.addMapping("/api/reservas/token/*").allowedOrigins("*"); 
                registry.addMapping("/api/reservas/token").allowedOrigins("*");
                registry.addMapping("/api/reservas/documento/*").allowedOrigins("*");
			}
		};
	}
}