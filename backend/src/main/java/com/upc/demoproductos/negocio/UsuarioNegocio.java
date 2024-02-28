package com.upc.demoproductos.negocio;

import com.upc.demoproductos.dto.UsuarioRequest;
import com.upc.demoproductos.dto.UsuarioResponse;
import com.upc.demoproductos.entidades.Paciente;
import com.upc.demoproductos.entidades.Psicologo;
import com.upc.demoproductos.repositorio.IPacienteRepositorio;
import com.upc.demoproductos.repositorio.IPsicologoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioNegocio implements IUsuarioNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IPacienteRepositorio iPacienteRepositorio;
    @Autowired
    IPsicologoRepositorio iPsicologoRepositorio;


    @Override
    public UsuarioResponse login(UsuarioRequest request) {
        return iPacienteRepositorio.findByEmailAndClave(request.getEmail(), request.getClave()).stream().findFirst()
                .map(this::mapUsuarioPaciente).orElseGet(() ->
                                iPsicologoRepositorio.findByEmailAndClave(request.getEmail(), request.getClave()).stream().findFirst().map(this::mapUsuarioPsicologo).orElse(null)
                        );
    }

    private UsuarioResponse mapUsuarioPaciente(Paciente paciente) {
        UsuarioResponse response = new UsuarioResponse();
        response.setTipo("PACIENTE");
        response.setDni(paciente.getDni());
        response.setNombres(paciente.getNombres());
        response.setApellidos(paciente.getApellidos());
        response.setCodigo(paciente.getCodigo());
        response.setGenero(paciente.getGenero());
        return response;
    }

    private UsuarioResponse mapUsuarioPsicologo(Psicologo psicologo) {
        UsuarioResponse response = new UsuarioResponse();
        response.setTipo("PSICOLOGO");
        response.setDni(psicologo.getDni());
        response.setNombres(psicologo.getNombres());
        response.setApellidos(psicologo.getApellidos());
        response.setCodigo(psicologo.getCodigo());
        response.setGenero(psicologo.getGenero());
        return response;
    }

}
