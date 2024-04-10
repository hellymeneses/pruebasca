package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.dto.PersonajeDto;
import com.example.pruebasca.personajes.transformer.PersonajeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ClientDetallePersonaje {

    private final WebClient webClient;

    private final PersonajeTransformer transformer;
    @Value("${rickyMorty.consultarPersonaje.url}")
    private String urlSerice;

    public ClientDetallePersonaje(WebClient webClient, PersonajeTransformer transformer) {
        this.webClient = webClient;
        this.transformer = transformer;
    }

    Mono<Personaje> consularDetallePersonaje(String id) {
        String url = urlSerice.concat(id);
        return webClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonajeDto.class)
                .map(transformer::toEntity)
                .doOnError(e -> {
                    log.error("Error al consultar detalle del personaje");
                });

    }
}
