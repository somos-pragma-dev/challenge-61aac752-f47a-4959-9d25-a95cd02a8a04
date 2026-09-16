package com.bancadigital.controller;

import com.bancadigital.dto.ClienteDTO;
import com.bancadigital.model.Cliente;
import com.bancadigital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try {
            ClienteDTO cliente = clienteService.obtenerPorId(id);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Cliente no encontrado", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity<?> buscarPorEmail(@RequestParam String email) {
        try {
            ClienteDTO cliente = clienteService.buscarPorEmail(email);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Cliente no encontrado", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/buscar/identificacion")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> buscarPorIdentificacion(@RequestParam String numero) {
        try {
            ClienteDTO cliente = clienteService.buscarPorIdentificacion(numero);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Cliente no encontrado", "mensaje", e.getMessage()));
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        try {
            ClienteDTO nuevoCliente = clienteService.crear(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al crear cliente", "mensaje", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            ClienteDTO clienteActualizado = clienteService.actualizar(id, cliente);
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al actualizar cliente", "mensaje", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            clienteService.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Cliente eliminado exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Error al eliminar cliente", "mensaje", e.getMessage()));
        }
    }

    @PatchMapping("/{id}/activar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> activar(@PathVariable Long id) {
        try {
            ClienteDTO cliente = clienteService.activar(id);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al activar cliente", "mensaje", e.getMessage()));
        }
    }

    @PatchMapping("/{id}/desactivar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> desactivar(@PathVariable Long id) {
        try {
            ClienteDTO cliente = clienteService.desactivar(id);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al desactivar cliente", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/{id}/saldo")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity<?> consultarSaldo(@PathVariable Long id) {
        try {
            BigDecimal saldo = clienteService.consultarSaldo(id);
            return ResponseEntity.ok(Map.of("clienteId", id, "saldo", saldo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Error al consultar saldo", "mensaje", e.getMessage()));
        }
    }

    @PostMapping("/{id}/depositar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> depositar(@PathVariable Long id, @RequestBody Map<String, BigDecimal> request) {
        try {
            BigDecimal monto = request.get("monto");
            if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Monto inválido", "mensaje", "El monto debe ser mayor a cero"));
            }
            ClienteDTO cliente = clienteService.depositar(id, monto);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al realizar depósito", "mensaje", e.getMessage()));
        }
    }

    @PostMapping("/{id}/retirar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> retirar(@PathVariable Long id, @RequestBody Map<String, BigDecimal> request) {
        try {
            BigDecimal monto = request.get("monto");
            if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Monto inválido", "mensaje", "El monto debe ser mayor a cero"));
            }
            ClienteDTO cliente = clienteService.retirar(id, monto);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Error al realizar retiro", "mensaje", e.getMessage()));
        }
    }
}