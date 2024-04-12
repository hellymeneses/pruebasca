package com.example.pruebasca.personajes.transformer;

import com.example.pruebasca.personajes.Personaje;
import com.example.pruebasca.personajes.dto.PersonajeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T11:41:28-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PersonajeTransformerImpl implements PersonajeTransformer {

    @Override
    public Personaje toEntity(PersonajeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personaje.PersonajeBuilder personaje = Personaje.builder();

        personaje.id( dto.getId() );
        personaje.name( dto.getName() );
        personaje.status( dto.getStatus() );
        personaje.species( dto.getSpecies() );
        personaje.type( dto.getType() );
        personaje.gender( dto.getGender() );
        personaje.image( dto.getImage() );

        return personaje.build();
    }
}
