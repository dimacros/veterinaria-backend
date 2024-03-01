package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.negocio.DistritoNegocio;
import com.upc.demoproductos.negocio.EspecialidadNegocio;
import com.upc.demoproductos.repositorio.IDistritoRepositorio;
import com.upc.demoproductos.repositorio.IEspecialidadRepositorio;
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
class EspecialidadTests {

	@Autowired
	private EspecialidadNegocio especialidadNegocio;

	@MockBean // Para simular el acceso a la DB
	private IEspecialidadRepositorio especialidadRepositorio;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRegistro() {
//		Especialidad especialidad = new Especialidad();
//		especialidad.setNombre("EspecialidadTest");
//		especialidadNegocio.registrar(especialidad);
//	}

	@Test
	void testListado() {
		when(especialidadRepositorio.findAll()).thenReturn(
				Stream.of(
						new Especialidad(1L, "salud Test1"),
						new Especialidad(2L, "salud Test2"),
						new Especialidad(3L, "salud Test3")
				).collect(Collectors.toList()));
		Assertions.assertEquals(3, especialidadNegocio.listado().size());
	}
}
