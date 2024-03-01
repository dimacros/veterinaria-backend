package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Cita;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.repositorio.ICitaRepositorio;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaNegocio implements ICitaNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    ICitaRepositorio iCitaRepositorio;

    @Override
    public Cita registrar(Cita cita) {
        return iCitaRepositorio.save(cita); // insert into
    }

    @Override
    public Cita buscar(Long codigo) throws Exception {
        // where id =
        return iCitaRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro la Cita con codigo: " + codigo));
    }

    @Override
    public List<Cita> listado() {
        return iCitaRepositorio.findAll(); // select * from tbl_producto;
    }

    @Override
    public Cita actualizar(Cita cita) throws Exception {
        buscar(cita.getCodigo()); // no requiere asignar a una var
        return iCitaRepositorio.save(cita);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Cita cita = buscar(id);
        iCitaRepositorio.delete(cita);
    }
}
