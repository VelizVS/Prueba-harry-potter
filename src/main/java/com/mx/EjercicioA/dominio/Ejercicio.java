package com.mx.EjercicioA.dominio;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejercicio {

    private String name;
    private String house;
    private JsonNode wand;
}

