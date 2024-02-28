package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.negocio.IDistritoNegocio;
import com.upc.demoproductos.negocio.IEspecialidadNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") // http://localhost:8080/api
public class EspecialidadRest {
    @Autowired
    private IEspecialidadNegocio especialidadNegocio;

    /*
    Example:
    {
      "nombre": "salud"
    }
     */
    @PostMapping("/especialidad") // http://localhost:8080/api/especialidad
    public Especialidad registrar(@RequestBody Especialidad especialidad) {
        return especialidadNegocio.registrar(especialidad);
    }

    @GetMapping("/especialidad") // http://localhost:8080/api/especialidad
    public List<Especialidad> listar() {
        return especialidadNegocio.listado();
    }
//
//    @GetMapping("/paciente/{id}") // http://localhost:8080/api/paciente/1
//    public Paciente buscarPorId(@PathVariable(value="id") Long id) {
//        Paciente p;
//        try {
//            p = distritoNegocio.buscar(id);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado", e);
//        }
//        return p;
//    }
//
//    @PutMapping("/paciente") // http://localhost:8080/api/paciente
//    public Paciente actualizar(@RequestBody Paciente paciente) throws Exception {
//        return distritoNegocio.actualizar(paciente);
//    }

    // TODO Eliminar

    // Swagger

    // HATEOAS

}

