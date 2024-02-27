package com.upc.demoproductos.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;
    private double precio;
    private int stock;

    // Se usan transient para que no persista en la DB
    private double total; // precio de venta

    public Producto() {
    }

    public Producto(Long codigo, String descripcion, double precio, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto = codigo: " + this.codigo + ", descripcion: " + this.descripcion + ", precio: " + this.precio + ", precio: " + this.stock + ", total: " + this.total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
