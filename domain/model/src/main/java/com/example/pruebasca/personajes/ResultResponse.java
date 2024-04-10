package com.example.pruebasca.personajes;


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

public class ResultResponse {

    private List<Personaje> results;
}
