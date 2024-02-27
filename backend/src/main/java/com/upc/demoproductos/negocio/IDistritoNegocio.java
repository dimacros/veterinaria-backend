package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Paciente;

import java.util.List;

public interface IDistritoNegocio {
    public Distrito registrar(Distrito distrito);

    public Distrito buscar(Long codigo) throws Exception;

    public List<Distrito> listado();

    public Distrito actualizar(Distrito distrito) throws Exception;

//    public boolean eliminar(Long codigo) throws Exception;
}
