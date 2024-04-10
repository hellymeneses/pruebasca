package com.example.pruebasca.personajes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Personaje {
    public String id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public String image;
}
