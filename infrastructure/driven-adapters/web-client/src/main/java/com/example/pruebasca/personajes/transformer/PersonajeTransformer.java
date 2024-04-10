package com.example.pruebasca.personajes.transformer;

import com.example.pruebasca.personajes.Personaje;
import com.example.pruebasca.personajes.dto.PersonajeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonajeTransformer {

    Personaje toEntity(PersonajeDto dto);


}
