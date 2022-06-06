package br.dev.silascunha.heisenberg.controller;

import br.dev.silascunha.heisenberg.dto.LoginResponse;
import br.dev.silascunha.heisenberg.dto.UsuarioLogin;
import br.dev.silascunha.heisenberg.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UsuarioLogin usuarioLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioLogin.getNomeUsuario(), usuarioLogin.getSenha())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenUtil.generateToken(authentication);

        return ResponseEntity.ok().body(new LoginResponse(token, "Bearer"));
    }

    @GetMapping("/user")
    public ResponseEntity<?> user() {
        //Se não estiver autenticado, retorna 401 automaticamente

        return ResponseEntity.ok().body(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
