package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Cita;
import com.upc.demoproductos.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICitaRepositorio extends JpaRepository<Cita, Long> {

    public List<Cita> findByEstadoStartingWith(String prefix); // Spring Data
}
