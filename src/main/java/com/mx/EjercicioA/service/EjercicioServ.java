package com.mx.EjercicioA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.EjercicioA.dominio.Ejercicio;

@Service

public class EjercicioServ {

	private final String apiUrl = "https://hp-api.onrender.com/api/characters";

	private RestTemplate restTemplate = new RestTemplate();

	public EjercicioServ(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}	
	
	
	@Autowired
	public Ejercicio[] obtenerPersonajes() {
		return restTemplate.getForObject(apiUrl, Ejercicio[].class);
	}

}
