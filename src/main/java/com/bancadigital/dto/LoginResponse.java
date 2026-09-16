package com.bancadigital.dto;

import java.time.Instant;

/**
 * DTO para responder con el token JWT tras una autenticación exitosa.
 * Contiene el token y metadatos relacionados con la sesión del cliente.
 * Este DTO es un record inmutable para mayor seguridad en la respuesta.
 */
public record LoginResponse(
    String token,
    String tipo,
    String email,
    Instant expiracion,
    Long clienteId
) {
    /**
     * Constructor principal que inicializa todos los campos de la respuesta.
     */
    public LoginResponse {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("El token no puede estar vacío");
        }
    }
    
    /**
     * Factory method para crear una respuesta exitosa con valores por defecto.
     */
    public static LoginResponse success(String token, String email, Instant expiracion, Long clienteId) {
        return new LoginResponse(token, "Bearer", email, expiracion, clienteId);
    }
    
    /**
     * Retorna el tiempo restante de validez del token en segundos.
     */
    public long getTiempoRestanteSegundos() {
        if (expiracion == null) {
            return 0;
        }
        return Math.max(0, expiracion.getEpochSecond() - Instant.now().getEpochSecond());
    }
    
    /**
     * Verifica si el token está próximo a expirar (menos de 5 minutos).
     */
    public boolean isTokenProximoExpirar() {
        return getTiempoRestanteSegundos() < 300;
    }
}