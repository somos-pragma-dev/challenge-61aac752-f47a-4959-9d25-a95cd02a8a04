package com.bancadigital.dto;

import com.bancadigital.model.Cliente;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ClienteDTO(
    Long id,
    String nombre,
    String apellido,
    String email,
    String telefono,
    String direccion,
    String numeroIdentificacion,
    BigDecimal saldo,
    LocalDate fechaRegistro,
    boolean activo
) {
    public ClienteDTO {
        if (email != null && !email.isBlank()) {
            email = email.trim().toLowerCase();
        }
        if (numeroIdentificacion != null) {
            numeroIdentificacion = numeroIdentificacion.trim().toUpperCase();
        }
    }
    
    public static ClienteDTO fromEntity(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        return new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getNumeroIdentificacion(),
            cliente.getSaldo(),
            cliente.getFechaRegistro(),
            cliente.isActivo()
        );
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public boolean tieneSaldoDisponible() {
        return saldo != null && saldo.compareTo(BigDecimal.ZERO) > 0;
    }
    
    public String getEmailEnmascarado() {
        if (email == null || !email.contains("@")) {
            return "N/A";
        }
        String[] partes = email.split("@");
        String usuario = partes[0];
        String dominio = partes[1];
        if (usuario.length() <= 2) {
            return "**@" + dominio;
        }
        return usuario.substring(0, 2) + "***@" + dominio;
    }
}