package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
@Table(name="TBL_PSICOLOGO")
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;
    private String distrito;
    private String cmp;
    private String cpp;
    private String experiencia;
//    private List<Especialidad> especialidades;
    private String estudios;
    private String email;
    private String clave;

    public Psicologo() {
    }

    public Psicologo(String nombres, String apellidos, String dni) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "nombres: " + this.nombres + ", apellidos: " + this.apellidos + ", dni: " + this.dni;
    }
}
