package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.repository.DetallePersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DetallePersonajeAdapter implements DetallePersonajeRepository {

    private final ClientDetallePersonaje clientDetallePersonaje;

    @Override
    public Mono<Personaje> consultarDetallePersonaje(String id){
        return clientDetallePersonaje.consularDetallePersonaje(id);
    }
}
