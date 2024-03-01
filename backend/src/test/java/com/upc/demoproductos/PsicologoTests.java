package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.negocio.PacienteNegocio;
import com.upc.demoproductos.negocio.PsicologoNegocio;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import com.upc.demoproductos.repositorio.IPsicologoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class PsicologoTests {

	@Autowired
	private PsicologoNegocio psicologoNegocio;

	@MockBean // Para simular el acceso a la DB
	private IPsicologoRepositorio psicologoRepositorio;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRegistro() {
//		Paciente paciente = new Paciente();
//		paciente.setNombres("Mario Test");
//		paciente.setApellidos("Inga Test");
//		pacienteNegocio.registrar(paciente);
//	}

	@Test
	void testListado() {
		when(psicologoRepositorio.findAll()).thenReturn(
				Stream.of(
						new Psicologo(1L, "Psicologo", "Test", "12345678",
								"Masculino", new Distrito(1L, "Lince"), "cmp123", "cpp12",
								"8", new Especialidad(1L, "salud"),
								"universitarios", "mario21ic@gmail.com", "clave123"),
						new Psicologo(1L, "Psicologo", "Test", "12345678",
								"Masculino", new Distrito(1L, "Lince"), "cmp123", "cpp12",
								"8", new Especialidad(1L, "salud"),
								"universitarios", "mario21ic@gmail.com", "clave123")
				).collect(Collectors.toList()));
		Assertions.assertEquals(2, psicologoNegocio.listado().size());
	}
}
