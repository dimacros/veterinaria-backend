package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.negocio.IPacienteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") // http://localhost:8080/api
public class PacienteRest {
    @Autowired
    private IPacienteNegocio pacienteNegocio;

    /*
    Example:
    {
      "nombres": "Mario",
      "apellidos": "Inga",
      "dni": "12345678",
      "genero": "string",
      "distrito": {
        "codigo": 1
      },
      "email": "mario21ic@gmail.com",
      "clave": "miclave123"
    }
     */
    @PostMapping("/paciente") // http://localhost:8080/api/producto
    public Paciente registrar(@RequestBody Paciente paciente) {
        return pacienteNegocio.registrar(paciente);
    }

    @GetMapping("/paciente") // http://localhost:8080/api/paciente
    public List<Paciente> listar() {
        return pacienteNegocio.listado();
    }

    @GetMapping("/paciente/{id}") // http://localhost:8080/api/paciente/1
    public Paciente buscarPorId(@PathVariable(value="id") Long id) {
        Paciente p;
        try {
            p = pacienteNegocio.buscar(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado", e);
        }
        return p;
    }

    @PutMapping("/paciente") // http://localhost:8080/api/paciente
    public Paciente actualizar(@RequestBody Paciente paciente) throws Exception {
        return pacienteNegocio.actualizar(paciente);
    }

    @DeleteMapping("/paciente")
    public void eliminar(@PathVariable Long id) throws Exception {
        pacienteNegocio.eliminar(id);
    }

    // Swagger

    // HATEOAS

}

