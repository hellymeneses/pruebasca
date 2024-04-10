package com.example.pruebasca.personajes.repository;

import com.example.pruebasca.personajes.Personaje;
import reactor.core.publisher.Flux;

public interface PersonajesRepository {
    Flux<Personaje> consultarListadoPersonCharacter();

}
