package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteNegocio implements IPacienteNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IPacienteRepositorio iPacienteRepositorio;

    @Override
    public Paciente registrar(Paciente paciente) {
        return iPacienteRepositorio.save(paciente); // insert into
    }

    @Override
    public Paciente buscar(Long codigo) throws Exception {
        // where id =
        return iPacienteRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro el Paciente con codigo: " + codigo));
    }

    @Override
    public List<Paciente> listado() {
        return iPacienteRepositorio.findAll(); // select * from tbl_producto;
    }

    @Override
    public Paciente actualizar(Paciente paciente) throws Exception {
        buscar(paciente.getCodigo()); // no requiere asignar a una var
        return iPacienteRepositorio.save(paciente);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Paciente paciente = buscar(id);
        iPacienteRepositorio.delete(paciente);
    }
}
