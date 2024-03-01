package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_PACIENTE")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_codigo")
    private Long codigo;

    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "distrito_codigo")
    private Distrito distrito;

    private String email;
    private String clave;

    public Paciente() {
    }

    public Paciente(Long codigo, String nombres, String apellidos, String dni, String genero, Distrito distrito, String email, String clave) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.genero = genero;
        this.distrito = distrito;
        this.email = email;
        this.clave = clave;
    }

//    public Paciente(String nombres, String apellidos, String dni) {
//        this.nombres = nombres;
//        this.apellidos = apellidos;
//        this.dni = dni;
//    }

    @Override
    public String toString() {
        return "nombres: " + this.nombres + ", apellidos: " + this.apellidos + ", dni: " + this.dni;
    }
}
