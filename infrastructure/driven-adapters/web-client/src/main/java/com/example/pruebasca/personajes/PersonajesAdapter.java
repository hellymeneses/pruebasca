package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.repository.PersonajesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class PersonajesAdapter implements PersonajesRepository {

    private final ClientPersonajes clientPersonCharacter;


    @Override
    public Flux<Personaje> consultarListadoPersonCharacter() {
        return clientPersonCharacter.consultarListadoPersonajes();
    }
}
