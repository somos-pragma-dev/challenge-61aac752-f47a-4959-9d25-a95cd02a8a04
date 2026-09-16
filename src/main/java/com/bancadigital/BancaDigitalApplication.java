package com.bancadigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Punto de entrada principal de la aplicación de Banca Digital.
 * Configura el contexto de Spring Boot y los beans globales de la aplicación.
 * La aplicación expone una API REST segura con autenticación JWT para
 * gestionar operaciones de clientes como consultas de saldo, transferencias
 * y solicitudes de préstamo.
 */
@SpringBootApplication
public class BancaDigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancaDigitalApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}