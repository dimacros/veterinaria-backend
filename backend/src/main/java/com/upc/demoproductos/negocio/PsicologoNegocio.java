package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import com.upc.demoproductos.repositorio.IPsicologoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoNegocio implements IPsicologoNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IPsicologoRepositorio iPsicologoRepositorio;

    @Override
    public Psicologo registrar(Psicologo psicologo) {
        return iPsicologoRepositorio.save(psicologo); // insert into
    }

    @Override
    public Psicologo buscar(Long codigo) throws Exception {
        // where id =
        return iPsicologoRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro el Psicologo con codigo: " + codigo));
    }

    @Override
    public List<Psicologo> listado() {
        return iPsicologoRepositorio.findAll(); // select * from tbl_producto;
    }

    @Override
    public Psicologo actualizar(Psicologo psicologo) throws Exception {
        buscar(psicologo.getCodigo()); // no requiere asignar a una var
        return iPsicologoRepositorio.save(psicologo);
    }
}
