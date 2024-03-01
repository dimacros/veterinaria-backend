package com.upc.demoproductos.dto;

import lombok.Data;

@Data
public class UsuarioResponse {

    private Long codigo;
    private String tipo;
    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;


}
