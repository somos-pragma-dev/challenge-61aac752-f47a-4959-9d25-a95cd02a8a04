package com.bancadigital.controller;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    private LoginRequest loginRequestValido;
    private LoginResponse loginResponseExitosa;

    @BeforeEach
    void setUp() {
        loginRequestValido = new LoginRequest("cliente@banca.com", "password123");
        Instant expiracion = Instant.now().plus(1, ChronoUnit.HOURS);
        loginResponseExitosa = LoginResponse.success("jwt.token.falso", "cliente@banca.com", expiracion, 1L);
    }

    @Test
    @DisplayName("POST /api/auth/login - Login exitoso retorna token JWT")
    void login_exitoso_retornaTokenJWT() throws Exception {
        when(authService.autenticar(any(LoginRequest.class))).thenReturn(loginResponseExitosa);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"cliente@banca.com\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.email").value("cliente@banca.com"))
                .andExpect(jsonPath("$.clienteId").value(1));
    }

    @Test
    @DisplayName("POST /api/auth/login - Credenciales invalidas retorna 401")
    void login_credencialesInvalidas_retorna401() throws Exception {
        when(authService.autenticar(any(LoginRequest.class)))
                .thenThrow(new org.springframework.security.authentication.BadCredentialsException("Credenciales inválidas"));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"invalido@banca.com\",\"password\":\"wrongpass\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /api/auth/login - Email vacio retorna 400")
    void login_emailVacio_retorna400() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"\",\"password\":\"password123\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login - Password vacio retorna 400")
    void login_passwordVacio_retorna400() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"cliente@banca.com\",\"password\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login - Request body vacio retorna 400")
    void login_requestBodyVacio_retorna400() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login - Formato JSON invalido retorna 400")
    void login_formatoJsonInvalido_retorna400() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("not valid json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login - Token proximo a expirar indica advertencia")
    void login_tokenProximoExpirar_indicaAdvertencia() throws Exception {
        Instant expiracionCercana = Instant.now().plus(2, ChronoUnit.MINUTES);
        LoginResponse respuestaTokenCorto = LoginResponse.success("jwt.token", "cliente@banca.com", expiracionCercana, 1L);
        when(authService.autenticar(any(LoginRequest.class))).thenReturn(respuestaTokenCorto);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"cliente@banca.com\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tiempoRestanteSegundos").value(120))
                .andExpect(jsonPath("$.tokenProximoExpirar").value(true));
    }

    @Test
    @DisplayName("POST /api/auth/login - Content-Type incorrecto retorna 415")
    void login_contentTypeIncorrecto_retorna415() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("{\"email\":\"test@test.com\"}"))
                .andExpect(status().isUnsupportedMediaType());
    }
}