package com.bancadigital.controller;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (!request.hasCredentials()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Credenciales incompletas", "mensaje", "Se requiere email y password"));
        }

        try {
            LoginResponse response = authService.autenticar(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Autenticación fallida", "mensaje", e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Token requerido", "mensaje", "Se requiere un token válido en el header Authorization"));
        }

        String token = authHeader.substring(7);
        try {
            LoginResponse response = authService.verificarYRenovarToken(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Token inválido", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validarToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("valido", false, "mensaje", "Token no proporcionado"));
        }

        String token = authHeader.substring(7);
        boolean valido = authService.validarToken(token);

        if (valido) {
            return ResponseEntity.ok(Map.of("valido", true, "mensaje", "Token vigente"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("valido", false, "mensaje", "Token expirado o inválido"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "No hay sesión activa"));
        }

        String token = authHeader.substring(7);
        authService.invalidarToken(token);
        return ResponseEntity.ok(Map.of("mensaje", "Sesión cerrada exitosamente"));
    }
}