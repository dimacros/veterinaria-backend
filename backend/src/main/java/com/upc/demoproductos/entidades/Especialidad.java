package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name="TBL_ESPECIALIDAD")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;

    public Especialidad() {
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre;
    }
}
