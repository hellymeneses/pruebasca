package com.example.pruebasca;

import com.example.pruebasca.personajes.ConsultarDetallePersonajeUseCase;
import com.example.pruebasca.personajes.ConsultarPersonajesUseCase;
import com.example.pruebasca.personajes.repository.DetallePersonajeRepository;
import com.example.pruebasca.personajes.repository.PersonajesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ConsultarPersonajesUseCase  consultarPersonajesUseCase(PersonajesRepository personajesRepository) {

        return new ConsultarPersonajesUseCase(personajesRepository);
    }

    @Bean
    public ConsultarDetallePersonajeUseCase consultarDetallePersonajeUseCase (DetallePersonajeRepository detalleRepository){
        return  new ConsultarDetallePersonajeUseCase(detalleRepository);
    }
}
