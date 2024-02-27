package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.ProductoNegocio;
import com.upc.demoproductos.repositorio.IProductoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoPruebaUnitaria {

    @Autowired
    private ProductoNegocio productoNegocio;

    @MockBean // para simular el acceso a la DB
    private IProductoRepositorio productoRepositorio;

    @Test
    void testCalcularPrecioVenta() {
        Producto producto = new Producto(1L, "Fanta", 3, 30);

        // cuando busque con codigo 1 entonces retorna el mismo producto
        when(productoRepositorio.findById(1L)).thenReturn(Optional.of(producto));

        try {
            assertEquals(3.24, productoNegocio.calcularPrecioVenta(producto), 0.01);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testListado() {
        when(productoRepositorio.findAll()).thenReturn(
                Stream.of(
                        new Producto(1L, "Fanta", 3, 30),
                        new Producto(2L, "Fanta Kola Inglesa", 4, 10),
                        new Producto(3L, "Satipena", 3, 30)
                ).collect(Collectors.toList()));
        Assertions.assertEquals(3, productoNegocio.listado().size());
    }

//    @Test
//    void testcalcularIGV() {
//        // arrange
//        Producto producto = new Producto();
//        producto.setDescripcion("Fanta");
//        producto.setPrecio(10);
//        producto.setStock(30);
//
//        // act
//        double igv = productoNegocio.calcularIGV(producto);
//
//        // assert
//
//    }
}
