package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Especialidad;

import java.util.List;

public interface IEspecialidadNegocio {
    public Especialidad registrar(Especialidad especialidad);

    public Especialidad buscar(Long codigo) throws Exception;

    public List<Especialidad> listado();

    public Especialidad actualizar(Especialidad especialidad) throws Exception;

//    public boolean eliminar(Long codigo) throws Exception;
}
