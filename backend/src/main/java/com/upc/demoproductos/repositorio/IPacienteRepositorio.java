package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPacienteRepositorio extends JpaRepository<Paciente, Long> {

    public List<Paciente> findByApellidosStartingWith(String prefix); // Spring Data

    public List<Paciente> findByNombresStartingWith(String prefix); // Spring Data

    // Hibernate
//    @Query("SELECT p FROM Paciente p WHERE p.descripcion like %:prefijo%")
//    public List<Producto> obtenerReportePorDescripcion(@Param("prefijo") String prefijo);
}
