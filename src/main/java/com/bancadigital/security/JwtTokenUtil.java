package com.bancadigital.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private final SecretKey secretKey;
    private final long expirationMillis;
    private final long refreshExpirationMillis;

    public JwtTokenUtil(
            @Value("${jwt.secret:miClaveSecretaMuyLargaParaJWTDeBancaDigital2024}") String secret,
            @Value("${jwt.expiration:3600000}") long expirationMillis,
            @Value("${jwt.refresh.expiration:86400000}") long refreshExpirationMillis) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMillis = expirationMillis;
        this.refreshExpirationMillis = refreshExpirationMillis;
    }

    public String generateToken(String email, Long clienteId, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("clienteId", clienteId);
        claims.put("role", role);
        return createToken(claims, email, expirationMillis);
    }

    public String generateRefreshToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "refresh");
        return createToken(claims, email, refreshExpirationMillis);
    }

    private String createToken(Map<String, Object> claims, String subject, long expiration) {
        Instant now = Instant.now();
        Date issuedAt = Date.from(now);
        Date expirationDate = Date.from(now.plusMillis(expiration));

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(issuedAt)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Long extractClienteId(String token) {
        Object clienteId = extractAllClaims(token).get("clienteId");
        if (clienteId instanceof Number) {
            return ((Number) clienteId).longValue();
        }
        return null;
    }

    public String extractRole(String token) {
        Object role = extractAllClaims(token).get("role");
        return role != null ? role.toString() : null;
    }

    public Instant extractExpiration(String token) {
        Date expiration = extractAllClaims(token).getExpiration();
        return expiration != null ? expiration.toInstant() : null;
    }

    public boolean validateToken(String token, String email) {
        try {
            final String tokenEmail = extractEmail(token);
            return (tokenEmail.equals(email) && !isTokenExpired(token));
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isTokenExpired(String token) {
        try {
            Date expiration = extractAllClaims(token).getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    public long getTiempoRestanteSegundos(String token) {
        try {
            Date expiration = extractAllClaims(token).getExpiration();
            long diff = expiration.getTime() - System.currentTimeMillis();
            return Math.max(0, diff / 1000);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isTokenProximoExpirar(String token) {
        long tiempoRestante = getTiempoRestanteSegundos(token);
        return tiempoRestante > 0 && tiempoRestante < 300;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}