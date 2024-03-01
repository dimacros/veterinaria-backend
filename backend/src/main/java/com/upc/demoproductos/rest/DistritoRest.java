package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.negocio.IDistritoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") // http://localhost:8080/api
public class DistritoRest {
    @Autowired
    private IDistritoNegocio distritoNegocio;


    /*
    Example:
    {
      "nombre": "Lince"
    }
     */
    @PostMapping("/distrito") // http://localhost:8080/api/distrito
    public Distrito registrar(@RequestBody Distrito distrito) {
        return distritoNegocio.registrar(distrito);
    }

    @GetMapping("/distrito") // http://localhost:8080/api/distrito
    public List<Distrito> listar() {
        return distritoNegocio.listado();
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

    @DeleteMapping("/distrito")
    public void eliminar(@PathVariable Long id) throws Exception {
        distritoNegocio.eliminar(id);
    }

    // Swagger

    // HATEOAS

}

