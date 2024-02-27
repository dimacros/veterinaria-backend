package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.repositorio.IEspecialidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadNegocio implements IEspecialidadNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IEspecialidadRepositorio iEspecialidadRepositorio;

    @Override
    public Especialidad registrar(Especialidad especialidad) {
        return iEspecialidadRepositorio.save(especialidad); // insert into
    }

    @Override
    public Especialidad buscar(Long codigo) throws Exception {
        // where id =
        return iEspecialidadRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro la Especialidad con codigo: " + codigo));
    }

    @Override
    public List<Especialidad> listado() {
        return iEspecialidadRepositorio.findAll(); // select * from tbl_distrito;
    }

    @Override
    public Especialidad actualizar(Especialidad especialidad) throws Exception {
        buscar(especialidad.getCodigo()); // no requiere asignar a una var
        return iEspecialidadRepositorio.save(especialidad);
    }
}
