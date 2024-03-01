package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.negocio.DistritoNegocio;
import com.upc.demoproductos.negocio.EspecialidadNegocio;
import com.upc.demoproductos.negocio.IDistritoNegocio;
import com.upc.demoproductos.repositorio.IDistritoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class DistritoTests {

	@Autowired
	private IDistritoNegocio distritoNegocio;
	@MockBean // Para simular el acceso a la DB
	private IDistritoRepositorio distritoRepositorio;

	@Test
	void contextLoads() {
	}

	@Test
	void testListado() {
//		List<Distrito> lista = distritoNegocio.listado();
//		for (Distrito d : lista) {
//			System.out.println(d);
//		}
		when(distritoRepositorio.findAll()).thenReturn(
			Stream.of(
					new Distrito(1L, "Lince Test1"),
					new Distrito(2L, "Lince Test2"),
					new Distrito(3L, "Lince Test3")
			).collect(Collectors.toList()));
		Assertions.assertEquals(3, distritoNegocio.listado().size());
	}
}
