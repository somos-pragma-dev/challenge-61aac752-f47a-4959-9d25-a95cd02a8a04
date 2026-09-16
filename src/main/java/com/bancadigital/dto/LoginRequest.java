package com.bancadigital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para recibir las credenciales de autenticación del cliente.
 * Utiliza validación de Bean Validation para asegurar que los datos
 * ingresados cumplan con los requisitos mínimos de seguridad.
 * Este DTO es un record en Java 21 para mayor inmutabilidad y eficiencia.
 */
public record LoginRequest(
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    String email,
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password
) {
    /**
     * Constructor canónico con validación de invariantes.
     * Valida que el email no contenga espacios en blanco y normaliza el formato.
     */
    public LoginRequest {
        if (email != null) {
            email = email.trim().toLowerCase();
        }
        if (password != null && password.contains(" ")) {
            throw new IllegalArgumentException("La contraseña no puede contener espacios en blanco");
        }
    }
    
    /**
     * Método para verificar si las credenciales están vacías.
     * Útil para logging sin exponer información sensible.
     */
    public boolean hasCredentials() {
        return email != null && !email.isBlank() && password != null && !password.isBlank();
    }
    
    /**
     * Retorna el email normalizado para logging.
     */
    public String getEmailForLog() {
        return email != null ? email : "N/A";
    }
}