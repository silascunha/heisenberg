package br.dev.silascunha.heisenberg.controller.openapi;

import org.springframework.http.ResponseEntity;

import br.dev.silascunha.heisenberg.dto.LoginResponse;
import br.dev.silascunha.heisenberg.dto.UsuarioLogin;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface AuthControllerOpenApi {

	ResponseEntity<LoginResponse> login(@RequestBody UsuarioLogin usuarioLogin);


	ResponseEntity<?> user();
}
