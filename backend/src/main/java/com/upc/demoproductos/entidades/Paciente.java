package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_PACIENTE")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;
    private String distrito;
    private String email;
    private String clave;

    public Paciente() {
    }

    public Paciente(String nombres, String apellidos, String dni) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "nombres: " + this.nombres + ", apellidos: " + this.apellidos + ", dni: " + this.dni;
    }
}
