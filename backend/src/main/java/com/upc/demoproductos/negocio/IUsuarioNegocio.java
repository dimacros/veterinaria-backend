package com.upc.demoproductos.negocio;

import com.upc.demoproductos.dto.UsuarioRequest;
import com.upc.demoproductos.dto.UsuarioResponse;

import java.util.List;

public interface IUsuarioNegocio {
    UsuarioResponse login(UsuarioRequest request);
}
