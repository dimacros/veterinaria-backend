package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Especialidad;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.negocio.DistritoNegocio;
import com.upc.demoproductos.negocio.PacienteNegocio;
import com.upc.demoproductos.repositorio.IEspecialidadRepositorio;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
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
class PacienteTests {

	@Autowired
	private PacienteNegocio pacienteNegocio;

	@MockBean // Para simular el acceso a la DB
	private IPacienteRepositorio pacienteRepositorio;

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
		when(pacienteRepositorio.findAll()).thenReturn(
				Stream.of(
						new Paciente(1L, "Mario", "Inga", "12345678", "Masculino", new Distrito(1L, "Lince"), "mario21ic@gmail.com", "clave123"),
						new Paciente(1L, "Mario", "Inga", "12345678", "Masculino", new Distrito(1L, "Lince"), "mario21ic@gmail.com", "clave123")
				).collect(Collectors.toList()));
		Assertions.assertEquals(2, pacienteNegocio.listado().size());
	}
}
