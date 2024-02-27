package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDistritoRepositorio extends JpaRepository<Distrito, Long> {

    public List<Paciente> findByNombreStartingWith(String prefix); // Spring Data
}
