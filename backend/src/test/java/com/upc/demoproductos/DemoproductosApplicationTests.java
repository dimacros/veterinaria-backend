package com.upc.demoproductos;

//import com.upc.demoproductos.entidades.Producto;
//import com.upc.demoproductos.negocio.ProductoNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoproductosApplicationTests {

	@Autowired
//	private ProductoNegocio productoNegocio;

	@Test
	void contextLoads() {
	}
//
//	@Test
//	void testRegistro() {
//		Producto producto = new Producto();
////		producto.setDescripcion("Fanta Kola Inglesa");
////		producto.setPrecio(4);
////		producto.setStock(10);
//
////		producto.setDescripcion("Fanta Limon 2");
////		producto.setPrecio(5);
////		producto.setStock(500);
//
//		producto.setDescripcion("Pepsi");
//		producto.setPrecio(3);
//		producto.setStock(100);
//		productoNegocio.registrar(producto);
////		assert
//	}
//
//	@Test
//	void testBuscar() {
//		try {
//			Producto producto = productoNegocio.buscar(1L);
////			System.out.println(producto.getDescripcion());
////			System.out.println(producto.toString());
//			System.out.println(producto);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	@Test
//	void testListado() {
//		List<Producto> lista = productoNegocio.listado();
//		for (Producto p : lista) {
//			System.out.println(p);
//		}
//	}
//
//	@Test
//	void testCalcularPrecioVenta() {
//		try {
//			double venta = productoNegocio.calcularPrecioVenta(1L);
//			System.out.println(venta);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	@Test
//	void testActualizarUnProducto() {
//		try {
////			Producto producto = productoNegocio.buscar(1L);
////			producto.setStock(500);
////			productoNegocio.actualizar(producto);
////			System.out.println(producto);
//
//			Producto producto = new Producto();
//			producto.setDescripcion("Fanta Naranja");
//			producto.setCodigo(10L);
//			producto.setPrecio(3);
//			producto.setStock(1000);
//			productoNegocio.actualizar(producto);
//
//		} catch (Exception e) {
////			throw new RuntimeException(e); // muestra todo el stack
//			System.out.println(e.getMessage());
//		}
//	}
//
//	// F
//	@Test
//	void testListadoDescripcion() {
//		List<Producto> listado = productoNegocio.listadoProductosPorDescripcion("Fanta");
//		System.out.println("Listado de productos buscados por nombre:");
//		for (Producto producto : listado) {
//			System.out.println(producto);
//		}
//	}
//
//	// G
//	@Test
//	void testListadoTotal() {
//		List<Producto> listado = productoNegocio.listadoTotal();
//		for (Producto producto : listado) {
//			System.out.println(producto);
//		}
//	}

	// E -> HOMEWORK
}
