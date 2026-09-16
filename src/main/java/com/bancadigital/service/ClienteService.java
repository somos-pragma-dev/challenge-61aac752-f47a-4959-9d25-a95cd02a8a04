package com.bancadigital.service;

import com.bancadigital.dto.ClienteDTO;
import com.bancadigital.model.Cliente;
import com.bancadigital.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepository.findAll()
                .stream()
                .filter(Cliente::isActivo)
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ClienteDTO> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .filter(Cliente::isActivo)
                .map(ClienteDTO::fromEntity);
    }

    public Optional<ClienteDTO> obtenerClientePorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .filter(Cliente::isActivo)
                .map(ClienteDTO::fromEntity);
    }

    public Optional<ClienteDTO> obtenerClientePorNumeroIdentificacion(String numeroIdentificacion) {
        return clienteRepository.findByNumeroIdentificacion(numeroIdentificacion)
                .filter(Cliente::isActivo)
                .map(ClienteDTO::fromEntity);
    }

    public boolean existeClienteConEmail(String email) {
        return clienteRepository.findByEmail(email).isPresent();
    }

    public boolean existeClienteConIdentificacion(String numeroIdentificacion) {
        return clienteRepository.findByNumeroIdentificacion(numeroIdentificacion).isPresent();
    }

    @Transactional
    public ClienteDTO crearCliente(String nombre, String apellido, String email, 
                                    String telefono, String direccion, String numeroIdentificacion, 
                                    String password) {
        if (existeClienteConEmail(email)) {
            throw new IllegalArgumentException("Ya existe un cliente con el correo electrónico proporcionado");
        }
        if (existeClienteConIdentificacion(numeroIdentificacion)) {
            throw new IllegalArgumentException("Ya existe un cliente con el número de identificación proporcionado");
        }

        Cliente nuevoCliente = new Cliente(nombre, apellido, email, numeroIdentificacion, password);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setDireccion(direccion);
        nuevoCliente.setSaldo(BigDecimal.ZERO);
        nuevoCliente.setFechaRegistro(LocalDate.now());
        nuevoCliente.setActivo(true);

        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        return ClienteDTO.fromEntity(clienteGuardado);
    }

    @Transactional
    public ClienteDTO actualizarInformacionPersonal(Long clienteId, String nombre, String apellido, 
                                                     String telefono, String direccion) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        if (nombre != null && !nombre.isBlank()) {
            cliente.setNombre(nombre);
        }
        if (apellido != null && !apellido.isBlank()) {
            cliente.setApellido(apellido);
        }
        if (telefono != null) {
            cliente.setTelefono(telefono);
        }
        if (direccion != null) {
            cliente.setDireccion(direccion);
        }

        Cliente clienteActualizado = clienteRepository.save(cliente);
        return ClienteDTO.fromEntity(clienteActualizado);
    }

    @Transactional
    public void habilitarCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        cliente.setActivo(true);
        clienteRepository.save(cliente);
    }

    @Transactional
    public void deshabilitarCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        cliente.setActivo(false);
        clienteRepository.save(cliente);
    }

    public BigDecimal consultarSaldo(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .filter(Cliente::isActivo)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado o inactivo"));
        return cliente.getSaldo();
    }

    @Transactional
    public void acreditarSaldo(Long clienteId, BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a acreditar debe ser mayor que cero");
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .filter(Cliente::isActivo)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado o inactivo"));

        cliente.actualizarSaldo(monto);
        clienteRepository.save(cliente);
    }

    @Transactional
    public void debitarSaldo(Long clienteId, BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a debitar debe ser mayor que cero");
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .filter(Cliente::isActivo)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado o inactivo"));

        if (!cliente.tieneSaldoSuficiente(monto)) {
            throw new IllegalStateException("Saldo insuficiente para realizar la operación");
        }

        cliente.actualizarSaldo(monto.negate());
        clienteRepository.save(cliente);
    }

    public List<ClienteDTO> buscarClientesConSaldoMayorA(BigDecimal montoMinimo) {
        return clienteRepository.findAll()
                .stream()
                .filter(Cliente::isActivo)
                .filter(c -> c.getSaldo() != null && c.getSaldo().compareTo(montoMinimo) > 0)
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ClienteDTO> buscarClientesRegistradosEntre(LocalDate fechaInicio, LocalDate fechaFin) {
        return clienteRepository.findAll()
                .stream()
                .filter(Cliente::isActivo)
                .filter(c -> c.getFechaRegistro() != null && 
                            !c.getFechaRegistro().isBefore(fechaInicio) && 
                            !c.getFechaRegistro().isAfter(fechaFin))
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public long contarClientesActivos() {
        return clienteRepository.countByActivo(true);
    }
}