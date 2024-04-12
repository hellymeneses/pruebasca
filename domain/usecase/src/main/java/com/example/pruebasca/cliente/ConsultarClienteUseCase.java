package com.example.pruebasca.cliente;

import com.example.pruebasca.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> consultarCliente(String numeroDocumento) {
        return clienteRepository.ConsultarCliente(numeroDocumento);
    }


}
