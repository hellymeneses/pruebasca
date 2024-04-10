package com.example.pruebasca.personajes.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
//@JsonIgnoreProperties(ignoreUnknown = true)
@ToString

public class ResultResponseDto {

    private List<PersonajeDto> results;
}
