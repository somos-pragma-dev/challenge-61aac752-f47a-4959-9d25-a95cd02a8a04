package com.bancadigital.controller;

import com.bancadigital.dto.ClienteDTO;
import com.bancadigital.model.Cliente;
import com.bancadigital.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    private Cliente clientePrueba;
    private ClienteDTO clienteDTOPrueba;

    @BeforeEach
    void setUp() {
        clientePrueba = new Cliente("Juan", "Perez", "juan@banca.com", "12345678", "password");
        clientePrueba.setId(1L);
        clientePrueba.setTelefono("+1234567890");
        clientePrueba.setDireccion("Calle Principal 123");
        clientePrueba.setSaldo(new BigDecimal("5000.00"));
        clientePrueba.setFechaRegistro(LocalDate.now());
        clientePrueba.setActivo(true);

        clienteDTOPrueba = ClienteDTO.fromEntity(clientePrueba);
    }

    @Test
    @DisplayName("GET /api/clientes - Sin autenticacion retorna 401")
    void listarClientes_sinAutenticacion_retorna401() throws Exception {
        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /api/clientes - Con usuario autenticado retorna lista de clientes")
    @WithMockUser(roles = "USER")
    void listarClientes_conAutenticacion_retornaLista() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTOPrueba);
        Page<ClienteDTO> pagina = new PageImpl<>(clientes);
        when(clienteService.obtenerTodosLosClientes()).thenReturn(clientes);

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].email").value("juan@banca.com"))
                .andExpect(jsonPath("$.totalElements").value(1));
    }

    @Test
    @DisplayName("GET /api/clientes/{id} - Cliente existente retorna detalles")
    @WithMockUser(roles = "USER")
    void obtenerCliente_clienteExistente_retornaDetalles() throws Exception {
        when(clienteService.obtenerClientePorId(1L)).thenReturn(Optional.of(clienteDTOPrueba));

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("juan@banca.com"))
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Perez"));
    }

    @Test
    @DisplayName("GET /api/clientes/{id} - Cliente inexistente retorna 404")
    @WithMockUser(roles = "USER")
    void obtenerCliente_clienteInexistente_retorna404() throws Exception {
        when(clienteService.obtenerClientePorId(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/clientes/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/clientes - Con rol ADMIN crea cliente exitosamente")
    @WithMockUser(roles = "ADMIN")
    void crearCliente_conRolAdmin_creaExitosamente() throws Exception {
        when(clienteService.crearCliente(any(ClienteDTO.class))).thenReturn(clienteDTOPrueba);

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"email\":\"juan@banca.com\",\"numeroIdentificacion\":\"12345678\",\"password\":\"password\",\"telefono\":\"+1234567890\",\"direccion\":\"Calle Principal 123\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("juan@banca.com"));
    }

    @Test
    @DisplayName("POST /api/clientes - Sin rol ADMIN retorna 403")
    @WithMockUser(roles = "USER")
    void crearCliente_sinRolAdmin_retorna403() throws Exception {
        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"email\":\"juan@banca.com\"}"))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("PUT /api/clientes/{id} - Actualiza cliente exitosamente")
    @WithMockUser(roles = "ADMIN")
    void actualizarCliente_actualizaExitosamente() throws Exception {
        when(clienteService.actualizarInformacionPersonal(eq(1L), any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(Optional.of(clienteDTOPrueba));

        mockMvc.perform(put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Juan Actualizado\",\"apellido\":\"Perez\",\"email\":\"juan@banca.com\",\"telefono\":\"+1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Perez"));
    }

    @Test
    @DisplayName("DELETE /api/clientes/{id} - Con rol ADMIN elimina cliente")
    @WithMockUser(roles = "ADMIN")
    void eliminarCliente_conRolAdmin_eliminaCliente() throws Exception {
        doNothing().when(clienteService).deshabilitarCliente(1L);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/clientes/{id} - Cliente inexistente retorna 404")
    @WithMockUser(roles = "ADMIN")
    void eliminarCliente_clienteInexistente_retorna404() throws Exception {
        doThrow(new com.bancadigital.exception.JwtAuthenticationException("Cliente no encontrado"))
                .when(clienteService).deshabilitarCliente(999L);

        mockMvc.perform(delete("/api/clientes/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/clientes - Con paginacion retorna resultados correctos")
    @WithMockUser(roles = "USER")
    void listarClientes_conPaginacion_retornaResultados() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTOPrueba, clienteDTOPrueba);
        Page<ClienteDTO> pagina = new PageImpl<>(clientes);
        when(clienteService.obtenerTodosLosClientes()).thenReturn(clientes);

        mockMvc.perform(get("/api/clientes")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.totalElements").value(2));
    }
}