package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Cita;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.negocio.ICitaNegocio;
import com.upc.demoproductos.negocio.IPacienteNegocio;
import com.upc.demoproductos.negocio.IPsicologoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api") // http://localhost:8080/api
public class CitaRest {
    @Autowired
    private IPacienteNegocio pacienteNegocio;
    @Autowired
    private IPsicologoNegocio psicologoNegocio;
    @Autowired
    private ICitaNegocio citaNegocio;

    /*
    Example:
    {
      "paciente": {
        "codigo": 1
      },
      "psicologo": {
        "codigo": 1
      },
      "fecha": "2024-03-01",
      "hora": "20:00",
      "estado": "reservado",
      "apuntes": ""
    }
     */
    @PostMapping("/cita") // http://localhost:8080/api/cita
    public Cita registrar(@RequestBody Cita cita) throws Exception {
        Paciente paciente = pacienteNegocio.buscar(cita.getPaciente().getCodigo());
        cita.setPaciente(paciente);

        Psicologo psicologo = psicologoNegocio.buscar(cita.getPsicologo().getCodigo());
        cita.setPsicologo(psicologo);

        return citaNegocio.registrar(cita);
    }

    @GetMapping("/cita") // http://localhost:8080/api/cita
    public List<Cita> listar() {
        return citaNegocio.listado();
    }

    @GetMapping("/cita/{id}") // http://localhost:8080/api/cita/1
    public Cita buscarPorId(@PathVariable(value="id") Long id) {
        Cita p;
        try {
            p = citaNegocio.buscar(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cita no encontrada", e);
        }
        return p;
    }

    @PutMapping("/cita") // http://localhost:8080/api/cita
    public Cita actualizar(@RequestBody Cita cita) throws Exception {
        return citaNegocio.actualizar(cita);
    }

    // TODO Eliminar

    // Swagger

    // HATEOAS

}

