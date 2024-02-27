package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_ESPECIALIDAD")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre;
    }
}
