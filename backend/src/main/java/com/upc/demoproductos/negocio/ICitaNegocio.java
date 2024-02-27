package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Cita;
import com.upc.demoproductos.entidades.Paciente;

import java.util.List;

public interface ICitaNegocio {
    public Cita registrar(Cita cita);

    public Cita buscar(Long codigo) throws Exception;

    public List<Cita> listado();

    public Cita actualizar(Cita cita) throws Exception;

//    public boolean eliminar(Long codigo) throws Exception;
}
