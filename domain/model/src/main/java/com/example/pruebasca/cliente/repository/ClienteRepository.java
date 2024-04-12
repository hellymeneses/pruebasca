package com.example.pruebasca.cliente.repository;


import com.example.pruebasca.cliente.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteRepository   {

    Mono<Cliente> ConsultarCliente(String numeroDocumento);

    Mono<Cliente> CrearCliente(Cliente cliente);


}
