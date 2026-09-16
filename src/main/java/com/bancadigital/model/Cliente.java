package com.bancadigital.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidad JPA para persistencia de datos de clientes en la base de datos.
 * Representa la tabla de clientes en el sistema de banca digital.
 * Utiliza anotaciones de JPA para mapear los atributos a columnas de la BD.
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 100)
    private String apellido;
    
    @Column(nullable = false, unique = true, length = 150)
    private String email;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 255)
    private String direccion;
    
    @Column(name = "numero_identificacion", nullable = false, unique = true, length = 20)
    private String numeroIdentificacion;
    
    @Column(precision = 19, scale = 4)
    private BigDecimal saldo;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
    
    @Column(nullable = false)
    private boolean activo;
    
    @Column(nullable = false, length = 255)
    private String password;
    
    /**
     * Constructor por defecto requerido por JPA.
     */
    public Cliente() {
        this.saldo = BigDecimal.ZERO;
        this.fechaRegistro = LocalDate.now();
        this.activo = true;
    }
    
    /**
     * Constructor con los campos obligatorios para crear un nuevo cliente.
     */
    public Cliente(String nombre, String apellido, String email, String numeroIdentificacion, String password) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email.toLowerCase().trim();
        this.numeroIdentificacion = numeroIdentificacion.toUpperCase().trim();
        this.password = password;
    }
    
    @PrePersist
    protected void onCreate() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDate.now();
        }
        if (saldo == null) {
            saldo = BigDecimal.ZERO;
        }
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Método para obtener el nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Método para verificar si el cliente puede realizar operaciones.
     */
    public boolean puedeOperar() {
        return activo && email != null && !email.isBlank();
    }
    
    /**
     * Método para actualizar el saldo del cliente.
     */
    public void actualizarSaldo(BigDecimal monto) {
        if (monto == null) {
            throw new IllegalArgumentException("El monto no puede ser nulo");
        }
        this.saldo = this.saldo.add(monto);
    }
    
    /**
     * Método para verificar si tiene saldo suficiente para una operación.
     */
    public boolean tieneSaldoSuficiente(BigDecimal monto) {
        if (monto == null || saldo == null) {
            return false;
        }
        return saldo.compareTo(monto) >= 0;
    }