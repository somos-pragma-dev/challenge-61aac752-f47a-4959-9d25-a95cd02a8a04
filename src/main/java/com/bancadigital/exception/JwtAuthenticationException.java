package com.bancadigital.exception;

public class JwtAuthenticationException extends RuntimeException {

    private final String codigoError;

    public JwtAuthenticationException(String mensaje) {
        super(mensaje);
        this.codigoError = "JWT_AUTH_ERROR";
    }

    public JwtAuthenticationException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.codigoError = "JWT_AUTH_ERROR";
    }

    public JwtAuthenticationException(String mensaje, String codigoError) {
        super(mensaje);
        this.codigoError = codigoError;
    }

    public JwtAuthenticationException(String mensaje, String codigoError, Throwable causa) {
        super(mensaje, causa);
        this.codigoError = codigoError;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public static JwtAuthenticationException tokenExpirado() {
        return new JwtAuthenticationException("El token JWT ha expirado", "TOKEN_EXPIRADO");
    }

    public static JwtAuthenticationException tokenInvalido() {
        return new JwtAuthenticationException("El token JWT es inválido", "TOKEN_INVALIDO");
    }

    public static JwtAuthenticationException tokenNoProporcionado() {
        return new JwtAuthenticationException("No se proporcionó un token JWT", "TOKEN_FALTANTE");
    }

    public static JwtAuthenticationException credencialesInvalidas() {
        return new JwtAuthenticationException("Las credenciales proporcionadas son inválidas", "CREDENCIALES_INVALIDAS");
    }

    public static JwtAuthenticationException cuentaInactiva() {
        return new JwtAuthenticationException("La cuenta de usuario está inactiva", "CUENTA_INACTIVA");
    }

    public static JwtAuthenticationException usuarioNoEncontrado(String identificador) {
        return new JwtAuthenticationException("Usuario no encontrado: " + identificador, "USUARIO_NO_ENCONTRADO");
    }

    public static JwtAuthenticationException errorDeFirma(String mensaje) {
        return new JwtAuthenticationException("Error en la firma del token: " + mensaje, "ERROR_FIRMA");
    }

    public static JwtAuthenticationException errorDeGeneracion(String mensaje) {
        return new JwtAuthenticationException("Error al generar el token: " + mensaje, "ERROR_GENERACION");
    }

    @Override
    public String toString() {
        return "JwtAuthenticationException{" +
                "codigoError='" + codigoError + '\'' +
                ", mensaje='" + getMessage() + '\'' +
                '}';
    }
}