package com.mx.EjercicioA.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	/*@GetMapping(path = "/personajes")
	public String verPerso(Model model) {
		Ejercicio[] characters = ejercicioServ.obtenerPersonajes();
		model.addAttribute("characters", characters);
		return "personaje";

	}
	*/
	
	@GetMapping(path = "/personajes")
	public String verPerso(Model model, @RequestParam(required = false) String searchText) {
	    Ejercicio[] characters = ejercicioServ.obtenerPersonajes();

	    if (searchText != null && !searchText.isEmpty()) {
	        List<Ejercicio> filteredCharacters = Arrays.stream(characters)
	            .filter(character -> character.getName().toLowerCase().contains(searchText.toLowerCase()))
	            .collect(Collectors.toList());
	        model.addAttribute("characters", filteredCharacters);
	    } else {
	        model.addAttribute("characters", Arrays.asList(characters));
	    }

	    return "personaje";
	}

}
