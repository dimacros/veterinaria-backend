package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Paciente;

import java.util.List;

public interface IPacienteNegocio {
    public Paciente registrar(Paciente paciente);

    public Paciente buscar(Long codigo) throws Exception;

    public List<Paciente> listado();

    public Paciente actualizar(Paciente paciente) throws Exception;

//    public boolean eliminar(Long codigo) throws Exception;
}
