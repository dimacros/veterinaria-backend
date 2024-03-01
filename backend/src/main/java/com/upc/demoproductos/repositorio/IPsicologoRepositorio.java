package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.entidades.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPsicologoRepositorio extends JpaRepository<Psicologo, Long> {

    public List<Especialidad> findByNombresStartingWith(String prefix); // Spring Data
    public List<Especialidad> findByApellidosStartingWith(String prefix); // Spring Data
    public List<Psicologo> findByEmailAndClave(String email, String clave);
}
