package com.example.pruebasca.cliente;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cliente {

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String correo;
}
