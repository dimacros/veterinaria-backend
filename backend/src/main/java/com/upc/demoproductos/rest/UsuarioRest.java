package com.upc.demoproductos.rest;

import com.upc.demoproductos.dto.BasicResponse;
import com.upc.demoproductos.dto.UsuarioRequest;
import com.upc.demoproductos.dto.UsuarioResponse;
import com.upc.demoproductos.negocio.IUsuarioNegocio;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") // http://localhost:8080/api
public class UsuarioRest {
    @Autowired
    private IUsuarioNegocio usuarioNegocio;

    /*
    Example:
    {
      "emmail": "test@test.com",
      "clave": "*******",
    }
     */
    @PostMapping("/login") // http://localhost:8080/api/login
    public ResponseEntity<?> registrar(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse response = usuarioNegocio.login(usuarioRequest);
        if(Objects.nonNull(response)) {
            return ResponseEntity.ok(response);
        } else {
            BasicResponse basicResponse = new BasicResponse();
            basicResponse.setMensaje("El email/contraseña son incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(basicResponse);
        }
    }

}

