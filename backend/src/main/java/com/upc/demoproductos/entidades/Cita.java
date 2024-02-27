package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name="TBL_CITA")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

//    private Paciente paciente;
//    private Psicologo psicologo;
//    private Especialidad especialidad;
    private String fecha;
    private String hora;
    private String estado;
    private String apuntes;

    public Cita() {
    }

//    public Cita(Paciente paciente, Psicologo psicologo, Especialidad especialidad) {
//        this.paciente = paciente;
//        this.psicologo = psicologo;
//        this.especialidad = especialidad;
//    }

    @Override
    public String toString() {
        return "fecha: " + this.fecha + ", hora: " + this.hora;
    }
}
