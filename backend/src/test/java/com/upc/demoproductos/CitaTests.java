package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Cita;
import com.upc.demoproductos.entidades.Distrito;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.negocio.CitaNegocio;
import com.upc.demoproductos.negocio.PacienteNegocio;
import com.upc.demoproductos.repositorio.ICitaRepositorio;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class CitaTests {

	@Autowired
	private CitaNegocio citaNegocio;

	@MockBean // Para simular el acceso a la DB
	private ICitaRepositorio citaRepositorio;

	@Test
	void contextLoads() {
	}

	// Long codigo, Paciente paciente, Psicologo psicologo,
	// String fecha, String hora, String estado, String apuntes
	@Test
	void testListado() {
		when(citaRepositorio.findAll()).thenReturn(
				Stream.of(
						new Cita(1L, new Paciente(), new Psicologo(),
								"20224-03-05", "18:20", "reservado", ""),
						new Cita(1L, new Paciente(), new Psicologo(),
								"20224-03-05", "18:20", "reservado", "")
				).collect(Collectors.toList()));
		Assertions.assertEquals(2, citaNegocio.listado().size());
	}
}
