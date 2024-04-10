package com.example.pruebasca.personajes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personaje")
@Slf4j
public class ConsultarDetallePersonajeService {

    private final ConsultarDetallePersonajeUseCase consultarDetallePersonajeUseCase;

    @GetMapping("/{id}")
    public Mono<Personaje> consultarDetallePersonaje(@PathVariable("id") String id) {
        return consultarDetallePersonajeUseCase.consultarDetallePersonaje(id)
                .doOnError(e -> {
                    log.info("error");
                });
    }

}
