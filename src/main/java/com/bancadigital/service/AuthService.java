package com.bancadigital.service;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.exception.JwtAuthenticationException;
import com.bancadigital.model.Cliente;
import com.bancadigital.repository.ClienteRepository;
import com.bancadigital.security.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final Map<String, Long> tokensInvalidados = new ConcurrentHashMap<>();

    public AuthService(ClienteRepository clienteRepository, JwtTokenUtil jwtTokenUtil,
                       PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse autenticar(LoginRequest request) {
        String email = request.getEmailForLog();
        String password = request.getPassword();
        
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(email);
        
        if (clienteOpt.isEmpty()) {
            throw JwtAuthenticationException.credencialesInvalidas();
        }
        
        Cliente cliente = clienteOpt.get();
        
        if (!cliente.isActivo()) {
            throw JwtAuthenticationException.cuentaInactiva();
        }
        
        if (!passwordEncoder.matches(password, cliente.getPassword())) {
            throw JwtAuthenticationException.credencialesInvalidas();
        }
        
        String token = jwtTokenUtil.generateToken(email, cliente.getId(), "USER");
        String refreshToken = jwtTokenUtil.generateRefreshToken(email);
        
        return LoginResponse.success(token, email, jwtTokenUtil.extractExpiration(token), cliente.getId());
    }

    public LoginResponse verificarYRenovarToken(String token) {
        if (tokensInvalidados.containsKey(token)) {
            throw JwtAuthenticationException.tokenInvalido();
        }
        
        if (!jwtTokenUtil.validateToken(token)) {
            throw JwtAuthenticationException.tokenExpirado();
        }
        
        String email = jwtTokenUtil.extractEmail(token);
        Long clienteId = jwtTokenUtil.extractClienteId(token);
        
        if (jwtTokenUtil.isTokenProximoExpirar(token)) {
            String nuevoToken = jwtTokenUtil.generateToken(email, clienteId, "USER");
            return LoginResponse.success(nuevoToken, email, jwtTokenUtil.extractExpiration(nuevoToken), clienteId);
        }
        
        return LoginResponse.success(token, email, jwtTokenUtil.extractExpiration(token), clienteId);
    }

    public void validarToken(String token) {
        if (tokensInvalidados.containsKey(token)) {
            throw JwtAuthenticationException.tokenInvalido();
        }
        
        if (!jwtTokenUtil.validateToken(token)) {
            throw JwtAuthenticationException.tokenExpirado();
        }
    }

    public Optional<Long> obtenerClienteIdDesdeToken(String token) {
        try {
            if (tokensInvalidados.containsKey(token)) {
                return Optional.empty();
            }
            
            if (!jwtTokenUtil.validateToken(token)) {
                return Optional.empty();
            }
            
            return Optional.of(jwtTokenUtil.extractClienteId(token));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean tokenEsValidoYActivo(String token) {
        try {
            if (tokensInvalidados.containsKey(token)) {
                return false;
            }
            
            String email = jwtTokenUtil.extractEmail(token);
            return jwtTokenUtil.validateToken(token, email);
        } catch (Exception e) {
            return false;
        }
    }
    
    public void invalidarToken(String token) {
        tokensInvalidados.put(token, System.currentTimeMillis());
    }
}