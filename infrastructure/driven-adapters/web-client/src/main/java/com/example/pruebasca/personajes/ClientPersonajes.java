package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.dto.ResultResponseDto;
import com.example.pruebasca.personajes.transformer.PersonajeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class ClientPersonajes {

    private final WebClient webClient;

    private final PersonajeTransformer transformer;

    @Value("${rickyMorty.consultarPersonaje.url}")
    private String urlService;


    public ClientPersonajes(WebClient webClient, PersonajeTransformer transformer) {
        this.webClient = webClient;
        this.transformer = transformer;
    }

    public Flux<Personaje> consultarListadoPersonajes() {
        return webClient
                .get()
                .uri(urlService)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ResultResponseDto.class)
                .flatMapIterable(ResultResponseDto::getResults)
                .map(transformer::toEntity)
                .doOnError(e -> {
                    log.error("Error en el servicio de rick and morty", e);
                });












               /* .bodyToMono(String.class)
                .flatMapMany(response-> {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    try {
                        ResultResponse resultResponse = mapper.readValue(response, ResultResponse.class);
                        return Flux.fromIterable(resultResponse.getResults());
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });*/







        /* .bodyToMono(Map.class)
                .doOnNext(resultResponse -> log.info("Respuesta: {}", resultResponse.get("results")))
                .flatMapMany(result->{
                    @SuppressWarnings("unchecked")
                    List<Personaje> personajes = (List<Personaje>) result.get("results");

                    return Flux.fromIterable(personajes);
                });*/

           /*      .bodyToMono(new ParameterizedTypeReference<ResultResponse>() {
                })
                .flatMapIterable(result -> result.getResults())
                .doOnError(e -> {
                    log.error("Error en el servicio de rick and morty", e);
                });

       response.subscribe(subscriptionResponse -> {
            System.out.println(subscriptionResponse.getName());
        });*/


    }
}

