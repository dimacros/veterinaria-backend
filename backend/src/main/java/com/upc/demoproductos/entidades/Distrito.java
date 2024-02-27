package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_DISTRITO")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distrito_codigo")
    private Long codigo;
    private String nombre;

    public Distrito() {
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre;
    }
}
