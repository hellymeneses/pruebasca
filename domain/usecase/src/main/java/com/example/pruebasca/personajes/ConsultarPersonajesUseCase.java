package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.repository.PersonajesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ConsultarPersonajesUseCase {

    private final PersonajesRepository personajesRepository;
        public Flux<Personaje> consultarListadoPersonajes() {
        return personajesRepository.consultarListadoPersonCharacter();
    }
}
