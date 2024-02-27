package com.upc.demoproductos.reset;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api") // http://localhost:8080/api
public class ProductoRest {
    @Autowired
    private IProductoNegocio productoNegocio;

    @GetMapping("/producto") // http://localhost:8080/api/producto
    public List<Producto> lista() {
        return productoNegocio.listado();
    }

    @GetMapping("/productoTotal") // http://localhost:8080/api/productoTotal
    public List<Producto> listadoTotal() {
        return productoNegocio.listadoTotal();
    }

    @GetMapping("/productoDescripcion/{descripcion}") // http://localhost:8080/api/productoDescripcion/descripcion
    public List<Producto> listadoDescripcion(@PathVariable(value="descripcion") String descripcion) {
        return productoNegocio.listadoProductosPorDescripcion(descripcion);
    }

    @PostMapping("/producto") // http://localhost:8080/api/producto
    public Producto registrar(@RequestBody Producto producto) {
        return productoNegocio.registrar(producto);
    }

    @GetMapping("/producto/{id}") // http://localhost:8080/api/producto/1
    public Producto buscarPorId(@PathVariable(value="id") Long id) {
        Producto p;
        try {
            p = productoNegocio.buscar(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado", e);
        }
        return p;
    }

    @PutMapping("/producto") // http://localhost:8080/api/producto
    public Producto actualizar(@RequestBody Producto producto) throws Exception {
        return productoNegocio.actualizar(producto);
    }

    // TODO Eliminar

    // Swagger

    // HATEOAS

}

