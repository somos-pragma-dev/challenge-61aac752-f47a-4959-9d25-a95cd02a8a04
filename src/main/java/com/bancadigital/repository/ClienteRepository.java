package com.bancadigital.repository;

import com.bancadigital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNumeroIdentificacion(String numeroIdentificacion);

    List<Cliente> findByActivoTrue();

    List<Cliente> findByActivoFalse();

    @Query("SELECT c FROM Cliente c WHERE c.saldo >= :saldoMinimo")
    List<Cliente> findClientesConSaldoMinimo(@Param("saldoMinimo") BigDecimal saldoMinimo);

    @Query("SELECT c FROM Cliente c WHERE c.fechaRegistro BETWEEN :fechaInicio AND :fechaFin")
    List<Cliente> findClientesRegistradosEntreFechas(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.activo = true")
    long countClientesActivos();

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(c.apellido) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Cliente> buscarPorNombreOApellido(@Param("nombre") String nombre);
}