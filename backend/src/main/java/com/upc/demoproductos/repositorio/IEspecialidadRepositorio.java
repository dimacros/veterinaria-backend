package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEspecialidadRepositorio extends JpaRepository<Especialidad, Long> {

    public List<Especialidad> findByNombreStartingWith(String prefix); // Spring Data
}
