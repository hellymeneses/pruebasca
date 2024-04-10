package com.example.pruebasca.personajes.repository;

import com.example.pruebasca.personajes.Personaje;
import reactor.core.publisher.Mono;

public interface DetallePersonajeRepository {

    Mono<Personaje> consultarDetallePersonaje (String id);
}
