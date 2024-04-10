package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.repository.DetallePersonajeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultarDetallePersonajeUseCase {

    private final DetallePersonajeRepository detallePersonajeRepository;

    public Mono<Personaje>consultarDetallePersonaje(String id){
        return detallePersonajeRepository.consultarDetallePersonaje(id);
    }


}
