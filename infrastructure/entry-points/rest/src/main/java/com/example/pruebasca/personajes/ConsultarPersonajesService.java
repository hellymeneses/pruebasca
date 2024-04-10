package com.example.pruebasca.personajes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personajes")
public class ConsultarPersonajesService {

    private final ConsultarPersonajesUseCase consultarPersonajesUseCase;

    @GetMapping
    public Flux<Personaje> consultarListadoPersonajes() {
        return consultarPersonajesUseCase.consultarListadoPersonajes()
                .doOnNext(personaje -> System.out.println(personaje));

    }

}

