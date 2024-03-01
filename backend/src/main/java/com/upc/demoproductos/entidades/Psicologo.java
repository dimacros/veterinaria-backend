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
    @Column(name = "psicologo_codigo")
    private Long codigo;

    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "distrito_codigo")
    private Distrito distrito;

    private String cmp;
    private String cpp;
    private String experiencia;

    @ManyToOne
    @JoinColumn(name = "especialidad_codigo")
    private Especialidad especialidad;

    private String estudios;
    private String email;
    private String clave;

    public Psicologo() {
    }

//    public Psicologo(String nombres, String apellidos, String dni) {
//        this.nombres = nombres;
//        this.apellidos = apellidos;
//        this.dni = dni;
//    }


    public Psicologo(Long codigo, String nombres, String apellidos, String dni, String genero, Distrito distrito, String cmp, String cpp, String experiencia, Especialidad especialidad, String estudios, String email, String clave) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.genero = genero;
        this.distrito = distrito;
        this.cmp = cmp;
        this.cpp = cpp;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
        this.estudios = estudios;
        this.email = email;
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "nombres: " + this.nombres + ", apellidos: " + this.apellidos + ", dni: " + this.dni;
    }
}
