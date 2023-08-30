package com.mx.EjercicioA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.EjercicioA.dominio.Ejercicio;
import com.mx.EjercicioA.service.EjercicioServ;

@Controller

public class Controlador {

	private EjercicioServ ejercicioServ;

	@Autowired
	public void PersonajeControl(EjercicioServ ejercicioServ) {
		this.ejercicioServ = ejercicioServ;
	}
	// http://localhost:8081/personajes
	@GetMapping(path = "/personajes")
	public String verPerso(Model model) {
		Ejercicio[] characters = ejercicioServ.obtenerPersonajes();
		model.addAttribute("characters", characters);
		return "personaje";

	}

}
