package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.repositorio.IDistritoRepositorio;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoNegocio implements IDistritoNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IDistritoRepositorio iDistritoRepositorio;

    @Override
    public Distrito registrar(Distrito distrito) {
        return iDistritoRepositorio.save(distrito); // insert into
    }

    @Override
    public Distrito buscar(Long codigo) throws Exception {
        // where id =
        return iDistritoRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro el Distrito con codigo: " + codigo));
    }

    @Override
    public List<Distrito> listado() {
        return iDistritoRepositorio.findAll(); // select * from tbl_distrito;
    }

    @Override
    public Distrito actualizar(Distrito distrito) throws Exception {
        buscar(distrito.getCodigo()); // no requiere asignar a una var
        return iDistritoRepositorio.save(distrito);
    }
}
