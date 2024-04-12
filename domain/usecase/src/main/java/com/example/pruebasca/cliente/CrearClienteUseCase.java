package com.example.pruebasca.cliente;

import com.example.pruebasca.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearClienteUseCase {

    private final ClienteRepository clienteRepository;

    Mono<Cliente> crearCliente( Cliente cliente){
        return clienteRepository.CrearCliente(cliente);
    }
}
