package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.negocio.IPacienteNegocio;
import com.upc.demoproductos.negocio.IPsicologoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") // http://localhost:8080/api
public class PsicologoRest {
    @Autowired
    private IPsicologoNegocio psicologoNegocio;

    /*
    Example:
    {
      "nombres": "Juan",
      "apellidos": "Perez",
      "dni": "87654321",
      "genero": "string",
      "distrito": {
        "codigo": 1
      },
      "cmp": "cmp123",
      "cpp": "cpp123",
      "experiencia": "8",
      "especialidad": {
        "codigo": 1
      },
      "estudios": "Universitarios",
      "email": "juanpe@gmail.com",
      "clave": "clave1234"
    }
     */
    @PostMapping("/psicologo") // http://localhost:8080/api/psicologo
    public Psicologo registrar(@RequestBody Psicologo psicologo) {
        return psicologoNegocio.registrar(psicologo);
    }

    @GetMapping("/psicologo") // http://localhost:8080/api/psicologo
    public List<Psicologo> listar() {
        return psicologoNegocio.listado();
    }

    @GetMapping("/psicologo/{id}") // http://localhost:8080/api/psicologo/1
    public Psicologo buscarPorId(@PathVariable(value="id") Long id) {
        Psicologo p;
        try {
            p = psicologoNegocio.buscar(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado", e);
        }
        return p;
    }

    @PutMapping("/psicologo") // http://localhost:8080/api/psicologo
    public Psicologo actualizar(@RequestBody Psicologo psicologo) throws Exception {
        return psicologoNegocio.actualizar(psicologo);
    }

    // TODO Eliminar

    // Swagger

    // HATEOAS

}

