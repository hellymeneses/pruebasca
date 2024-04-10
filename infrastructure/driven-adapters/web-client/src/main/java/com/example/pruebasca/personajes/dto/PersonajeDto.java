package com.example.pruebasca.personajes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonajeDto {

    public String id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public String image;
}
