package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;

import java.util.List;

public interface IPsicologoNegocio {
    public Psicologo registrar(Psicologo psicologo);

    public Psicologo buscar(Long codigo) throws Exception;

    public List<Psicologo> listado();

    public Psicologo actualizar(Psicologo psicologo) throws Exception;

//    public boolean eliminar(Long codigo) throws Exception;
}
