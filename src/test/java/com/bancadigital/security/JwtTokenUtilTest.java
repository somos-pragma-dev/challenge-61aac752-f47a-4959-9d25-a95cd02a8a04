package com.bancadigital.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenUtilTest {

    private JwtTokenUtil jwtTokenUtil;
    private SecretKey secretKey;
    private static final String SECRET = "miSecretKeyParaPruebasDeJWTQueEsMuyLargaParaHS256";
    private static final String USERNAME = "test@banca.com";
    private static final Long USER_ID = 1L;

    @BeforeEach
    void setUp() {
        jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "secret", SECRET);
        ReflectionTestUtils.setField(jwtTokenUtil, "expiration", 3600000L);
        secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Generar token con parametros validos retorna token no nulo")
    void generateToken_parametrosValidos_retornaTokenNoNulo() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.length() > 0);
    }

    @Test
    @DisplayName("Generar token contiene el username en los claims")
    void generateToken_contieneUsernameEnClaims() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(USERNAME, claims.getSubject());
    }

    @Test
    @DisplayName("Generar token contiene el userId en los claims")
    void generateToken_contieneUserIdEnClaims() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(USER_ID, claims.get("userId", Long.class));
    }

    @Test
    @DisplayName("Extraer username del token retorna valor correcto")
    void extractUsername_tokenValido_retornaUsername() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        String usernameExtraido = jwtTokenUtil.extractEmail(token);

        assertEquals(USERNAME, usernameExtraido);
    }

    @Test
    @DisplayName("Extraer userId del token retorna valor correcto")
    void extractUserId_tokenValido_retornaUserId() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        Long userIdExtraido = jwtTokenUtil.extractClienteId(token);

        assertEquals(USER_ID, userIdExtraido);
    }

    @Test
    @DisplayName("Validar token valido retorna true")
    void validateToken_tokenValido_retornaTrue() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        boolean esValido = jwtTokenUtil.validateToken(token);

        assertTrue(esValido);
    }

    @Test
    @DisplayName("Validar token expirado retorna false")
    void validateToken_tokenExpirado_retornaFalse() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", USER_ID);
        
        Date fechaExpirada = new Date(System.currentTimeMillis() - 1000);
        String tokenExpirado = Jwts.builder()
                .claims(claims)
                .subject(USERNAME)
                .expiration(fechaExpirada)
                .issuedAt(new Date(System.currentTimeMillis() - 10000))
                .signWith(secretKey)
                .compact();

        boolean esValido = jwtTokenUtil.validateToken(tokenExpirado);

        assertFalse(esValido);
    }

    @Test
    @DisplayName("Validar token con firma incorrecta lanza excepcion")
    void validateToken_firmaIncorrecta_lanzaExcepcion() {
        String tokenValido = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");
        SecretKey otraClave = Keys.hmacShaKeyFor("otraClaveSecretaParaPruebasQueEsLarga".getBytes(StandardCharsets.UTF_8));
        String tokenFirmadoIncorrectamente = Jwts.builder()
                .subject(USERNAME)
                .claim("userId", USER_ID)
                .signWith(otraClave)
                .compact();

        assertThrows(SignatureException.class, () -> jwtTokenUtil.validateToken(tokenFirmadoIncorrectamente));
    }

    @Test
    @DisplayName("Validar token malformado lanza excepcion")
    void validateToken_tokenMalformado_lanzaExcepcion() {
        String tokenMalformado = "esto.no.es.un.token.jwt.valido";

        assertThrows(MalformedJwtException.class, () -> jwtTokenUtil.validateToken(tokenMalformado));
    }

    @Test
    @DisplayName("Validar token nulo lanza excepcion")
    void validateToken_tokenNulo_lanzaExcepcion() {
        assertThrows(NullPointerException.class, () -> jwtTokenUtil.validateToken(null));
    }

    @Test
    @DisplayName("Extraer username de token nulo lanza excepcion")
    void extractUsername_tokenNulo_lanzaExcepcion() {
        assertThrows(NullPointerException.class, () -> jwtTokenUtil.extractEmail(null));
    }

    @Test
    @DisplayName("Verificar expiracion de token retorna false para token valido")
    void isTokenExpired_tokenValido_retornaFalse() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        boolean expirado = jwtTokenUtil.isTokenExpired(token);

        assertFalse(expirado);
    }

    @Test
    @DisplayName("Verificar expiracion de token retorna true para token expirado")
    void isTokenExpired_tokenExpirado_retornaTrue() {
        Date fechaExpirada = new Date(System.currentTimeMillis() - 1000);
        String tokenExpirado = Jwts.builder()
                .subject(USERNAME)
                .expiration(fechaExpirada)
                .signWith(secretKey)
                .compact();

        boolean expirado = jwtTokenUtil.isTokenExpired(tokenExpirado);

        assertTrue(expirado);
    }

    @Test
    @DisplayName("Obtener fecha de expiracion del token")
    void getExpirationDate_tokenValido_retornaFechaFutura() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        Instant fechaExpiracion = jwtTokenUtil.extractExpiration(token);

        assertNotNull(fechaExpiracion);
        assertTrue(fechaExpiracion.isAfter(Instant.now()));
    }

    @Test
    @DisplayName("Tokens diferentes generan valores diferentes")
    void generateToken_diferentesUsuarios_generaTokensDistintos() {
        String token1 = jwtTokenUtil.generateToken("usuario1@banca.com", 1L, "USER");
        String token2 = jwtTokenUtil.generateToken("usuario2@banca.com", 2L, "USER");

        assertNotEquals(token1, token2);
    }

    @Test
    @DisplayName("Mismo usuario genera tokens diferentes por timestamp")
    void generateToken_mismoUsuario_generaTokensDistintos() throws InterruptedException {
        String token1 = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");
        Thread.sleep(10);
        String token2 = jwtTokenUtil.generateToken(USERNAME, USER_ID, "USER");

        assertNotEquals(token1, token2);
    }
}