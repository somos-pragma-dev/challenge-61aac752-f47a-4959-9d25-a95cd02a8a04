# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/bancadigital/controller/ClienteControllerTest.java` — `JwtAuthenticationException`: JwtAuthenticationException se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bancadigital.exception.JwtAuthenticationException.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.listarTodos`: Se invoca `listarTodos` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.obtenerPorId`: Se invoca `obtenerPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.buscarPorEmail`: Se invoca `buscarPorEmail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.buscarPorIdentificacion`: Se invoca `buscarPorIdentificacion` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.crear`: Se invoca `crear` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.actualizar`: Se invoca `actualizar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.eliminar`: Se invoca `eliminar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.activar`: Se invoca `activar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.desactivar`: Se invoca `desactivar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.depositar`: Se invoca `depositar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.retirar`: Se invoca `retirar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findAll`: Se invoca `findAll` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findById`: Se invoca `findById` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findByNumeroIdentificacion`: Se invoca `findByNumeroIdentificacion` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.save`: Se invoca `save` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.countByActivo`: Se invoca `countByActivo` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bancadigital/service/AuthService.java` — `LoginRequest.getPassword`: Se invoca `getPassword` sobre `LoginRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Implementar autenticacion JWT en una API REST con Spring Security

### Reto
- Tema: seguridad-en-api-rest
- Seniority: junior-l2
- Tipo: practical
- Título: Implementación de autenticación JWT en una API REST
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del entorno de desarrollo — objetivo: Preparar el entorno de desarrollo para implementar la autenticación JWT. — entregable (NO resolver): Entorno de desarrollo configurado y listo para la implementación de la autenticación JWT.
- Fase 2: Implementación de la autenticación JWT — objetivo: Implementar la autenticación JWT en la API REST. — entregable (NO resolver): API REST con autenticación JWT implementada y funcionando.
- Fase 3: Pruebas y optimización — objetivo: Realizar pruebas y optimizar la implementación de la autenticación JWT. — entregable (NO resolver): API REST con autenticación JWT optimizada y con pruebas unitarias y de integración realizadas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.bancadigital</groupId>
    <artifactId>banca-digital</artifactId>
    <version>1.0.0</version>
    <name>banca-digital</name>
    <description>API REST con autenticación JWT para plataforma de banca digital</description>
    
    <properties>
        <java.version>21</java.version>
        <jjwt.version>0.12.5</jjwt.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bancadigital/BancaDigitalApplication.java ===
package com.bancadigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Punto de entrada principal de la aplicación de Banca Digital.
 * Configura el contexto de Spring Boot y los beans globales de la aplicación.
 * La aplicación expone una API REST segura con autenticación JWT para
 * gestionar operaciones de clientes como consultas de saldo, transferencias
 * y solicitudes de préstamo.
 */
@SpringBootApplication
public class BancaDigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancaDigitalApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/dto/LoginRequest.java ===
package com.bancadigital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para recibir las credenciales de autenticación del cliente.
 * Utiliza validación de Bean Validation para asegurar que los datos
 * ingresados cumplan con los requisitos mínimos de seguridad.
 * Este DTO es un record en Java 21 para mayor inmutabilidad y eficiencia.
 */
public record LoginRequest(
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    String email,
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password
) {
    /**
     * Constructor canónico con validación de invariantes.
     * Valida que el email no contenga espacios en blanco y normaliza el formato.
     */
    public LoginRequest {
        if (email != null) {
            email = email.trim().toLowerCase();
        }
        if (password != null && password.contains(" ")) {
            throw new IllegalArgumentException("La contraseña no puede contener espacios en blanco");
        }
    }
    
    /**
     * Método para verificar si las credenciales están vacías.
     * Útil para logging sin exponer información sensible.
     */
    public boolean hasCredentials() {
        return email != null && !email.isBlank() && password != null && !password.isBlank();
    }
    
    /**
     * Retorna el email normalizado para logging.
     */
    public String getEmailForLog() {
        return email != null ? email : "N/A";
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/dto/LoginResponse.java ===
package com.bancadigital.dto;

import java.time.Instant;

/**
 * DTO para responder con el token JWT tras una autenticación exitosa.
 * Contiene el token y metadatos relacionados con la sesión del cliente.
 * Este DTO es un record inmutable para mayor seguridad en la respuesta.
 */
public record LoginResponse(
    String token,
    String tipo,
    String email,
    Instant expiracion,
    Long clienteId
) {
    /**
     * Constructor principal que inicializa todos los campos de la respuesta.
     */
    public LoginResponse {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("El token no puede estar vacío");
        }
    }
    
    /**
     * Factory method para crear una respuesta exitosa con valores por defecto.
     */
    public static LoginResponse success(String token, String email, Instant expiracion, Long clienteId) {
        return new LoginResponse(token, "Bearer", email, expiracion, clienteId);
    }
    
    /**
     * Retorna el tiempo restante de validez del token en segundos.
     */
    public long getTiempoRestanteSegundos() {
        if (expiracion == null) {
            return 0;
        }
        return Math.max(0, expiracion.getEpochSecond() - Instant.now().getEpochSecond());
    }
    
    /**
     * Verifica si el token está próximo a expirar (menos de 5 minutos).
     */
    public boolean isTokenProximoExpirar() {
        return getTiempoRestanteSegundos() < 300;
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/dto/ClienteDTO.java ===
package com.bancadigital.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO para transferencia de datos de clientes entre capas.
 * Separa la representación interna de la entidad de persistencia,
 * permitiendo controlar qué información se expone externamente.
 * Este DTO es un record inmutable para mayor seguridad y rendimiento.
 */
public record ClienteDTO(
    Long id,
    String nombre,
    String apellido,
    String email,
    String telefono,
    String direccion,
    String numeroIdentificacion,
    BigDecimal saldo,
    LocalDate fechaRegistro,
    boolean activo
) {
    /**
     * Constructor con validación de invariantes de negocio.
     */
    public ClienteDTO {
        if (email != null && !email.isBlank()) {
            email = email.trim().toLowerCase();
        }
        if (numeroIdentificacion != null) {
            numeroIdentificacion = numeroIdentificacion.trim().toUpperCase();
        }
    }
    
    /**
     * Factory method para crear un ClienteDTO desde una entidad.
     */
    public static ClienteDTO fromEntity(com.bancadigital.model.Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        return new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getNumeroIdentificacion(),
            cliente.getSaldo(),
            cliente.getFechaRegistro(),
            cliente.isActivo()
        );
    }
    
    /**
     * Retorna el nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Verifica si el cliente tiene saldo disponible para operaciones.
     */
    public boolean tieneSaldoDisponible() {
        return saldo != null && saldo.compareTo(BigDecimal.ZERO) > 0;
    }
    
    /**
     * Retorna el email enmascarado para mostrar en logs o UI.
     */
    public String getEmailEnmascarado() {
        if (email == null || !email.contains("@")) {
            return "N/A";
        }
        String[] partes = email.split("@");
        String usuario = partes[0];
        String dominio = partes[1];
        if (usuario.length() <= 2) {
            return "**@" + dominio;
        }
        return usuario.substring(0, 2) + "***@" + dominio;
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/model/Cliente.java ===
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


// === ARCHIVO: src/main/java/com/bancadigital/repository/ClienteRepository.java ===
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

// === ARCHIVO: src/main/java/com/bancadigital/config/SecurityConfig.java ===
package com.bancadigital.config;

import com.bancadigital.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          UserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/actuator/health").permitAll()
                .requestMatchers("/api/clientes/**").hasRole("CLIENTE")
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
                .xssProtection(xss -> {})
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/security/JwtAuthenticationFilter.java ===
package com.bancadigital.security;

import com.bancadigital.exception.JwtAuthenticationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final int BEARER_PREFIX_LENGTH = 7;

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil,
                                   UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = extractJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && jwtTokenUtil.validateToken(jwt)) {
                String email = jwtTokenUtil.extractUsername(jwt);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                    if (jwtTokenUtil.validateToken(jwt, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                            );
                        authentication.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                        );

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (JwtAuthenticationException e) {
            logger.error("Error de autenticación JWT: " + e.getMessage(), e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Token JWT inválido o expirado\"}");
            return;
        } catch (Exception e) {
            logger.error("Error inesperado en filtro JWT: " + e.getMessage(), e);
        }

        filterChain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX_LENGTH);
        }

        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/api/auth/") ||
               path.startsWith("/h2-console/") ||
               path.startsWith("/actuator/");
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/security/JwtTokenUtil.java ===
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
// === ARCHIVO: src/main/java/com/bancadigital/controller/AuthController.java ===
package com.bancadigital.controller;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (!request.hasCredentials()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Credenciales incompletas", "mensaje", "Se requiere email y password"));
        }

        try {
            LoginResponse response = authService.autenticar(
                    request.getEmailForLog(),
                    request.getPassword()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Autenticación fallida", "mensaje", e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Token requerido", "mensaje", "Se requiere un token válido en el header Authorization"));
        }

        String token = authHeader.substring(7);
        try {
            LoginResponse response = authService.refreshToken(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Token inválido", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validarToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("valido", false, "mensaje", "Token no proporcionado"));
        }

        String token = authHeader.substring(7);
        boolean valido = authService.validarToken(token);

        if (valido) {
            return ResponseEntity.ok(Map.of("valido", true, "mensaje", "Token vigente"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("valido", false, "mensaje", "Token expirado o inválido"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "No hay sesión activa"));
        }

        String token = authHeader.substring(7);
        authService.invalidarToken(token);
        return ResponseEntity.ok(Map.of("mensaje", "Sesión cerrada exitosamente"));
    }
}
// === ARCHIVO: src/main/java/com/bancadigital/controller/ClienteController.java ===
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

// === ARCHIVO: src/main/java/com/bancadigital/service/ClienteService.java ===
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

// === ARCHIVO: src/main/java/com/bancadigital/service/AuthService.java ===
package com.bancadigital.service;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.exception.JwtAuthenticationException;
import com.bancadigital.model.Cliente;
import com.bancadigital.repository.ClienteRepository;
import com.bancadigital.security.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(ClienteRepository clienteRepository, JwtTokenUtil jwtTokenUtil, 
                       PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse autenticar(LoginRequest request) {
        if (!request.hasCredentials()) {
            throw new JwtAuthenticationException("Credenciales no proporcionadas");
        }

        String email = request.getEmailForLog();
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(email);

        if (clienteOpt.isEmpty()) {
            throw new JwtAuthenticationException("Credenciales inválidas");
        }

        Cliente cliente = clienteOpt.get();

        if (!cliente.isActivo()) {
            throw new JwtAuthenticationException("La cuenta del cliente está inactiva");
        }

        if (!cliente.puedeOperar()) {
            throw new JwtAuthenticationException("El cliente no puede operar en este momento");
        }

        String rawPassword = request.getPassword();
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new JwtAuthenticationException("La contraseña no puede estar vacía");
        }

        if (!passwordEncoder.matches(rawPassword, cliente.getPassword())) {
            throw new JwtAuthenticationException("Credenciales inválidas");
        }

        String token = jwtTokenUtil.generateToken(cliente);
        Instant expiracion = jwtTokenUtil.getExpirationDateFromToken(token);

        return LoginResponse.success(token, cliente.getEmail(), expiracion, cliente.getId());
    }

    public LoginResponse verificarYRenovarToken(String token) {
        if (token == null || token.isBlank()) {
            throw new JwtAuthenticationException("Token no proporcionado");
        }

        if (!jwtTokenUtil.validateToken(token)) {
            throw new JwtAuthenticationException("Token inválido o expirado");
        }

        String email = jwtTokenUtil.getUsernameFromToken(token);
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(email);

        if (clienteOpt.isEmpty()) {
            throw new JwtAuthenticationException("Usuario asociado al token no encontrado");
        }

        Cliente cliente = clienteOpt.get();

        if (!cliente.isActivo()) {
            throw new JwtAuthenticationException("La cuenta del cliente está inactiva");
        }

        if (jwtTokenUtil.isTokenProximoExpirar(token)) {
            String nuevoToken = jwtTokenUtil.generateToken(cliente);
            Instant expiracion = jwtTokenUtil.getExpirationDateFromToken(nuevoToken);
            return LoginResponse.success(nuevoToken, cliente.getEmail(), expiracion, cliente.getId());
        }

        Instant expiracion = jwtTokenUtil.getExpirationDateFromToken(token);
        return LoginResponse.success(token, cliente.getEmail(), expiracion, cliente.getId());
    }

    public void validarToken(String token) {
        if (token == null || token.isBlank()) {
            throw new JwtAuthenticationException("Token no proporcionado");
        }

        if (!jwtTokenUtil.validateToken(token)) {
            throw new JwtAuthenticationException("Token inválido o expirado");
        }

        String email = jwtTokenUtil.getUsernameFromToken(token);
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(email);

        if (clienteOpt.isEmpty()) {
            throw new JwtAuthenticationException("Usuario asociado al token no encontrado");
        }

        Cliente cliente = clienteOpt.get();
        if (!cliente.isActivo()) {
            throw new JwtAuthenticationException("La cuenta del cliente está inactiva");
        }
    }

    public Optional<Long> obtenerClienteIdDesdeToken(String token) {
        try {
            if (token != null && jwtTokenUtil.validateToken(token)) {
                String email = jwtTokenUtil.getUsernameFromToken(token);
                return clienteRepository.findByEmail(email)
                        .filter(Cliente::isActivo)
                        .map(Cliente::getId);
            }
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    public boolean tokenEsValidoYActivo(String token) {
        try {
            if (token == null || token.isBlank()) {
                return false;
            }

            if (!jwtTokenUtil.validateToken(token)) {
                return false;
            }

            String email = jwtTokenUtil.getUsernameFromToken(token);
            Optional<Cliente> clienteOpt = clienteRepository.findByEmail(email);

            return clienteOpt.isPresent() && clienteOpt.get().isActivo();
        } catch (Exception e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/exception/JwtAuthenticationException.java ===
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

// === ARCHIVO: src/test/java/com/bancadigital/controller/AuthControllerTest.java ===
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
        when(authService.authenticate(any(LoginRequest.class))).thenReturn(loginResponseExitosa);

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
        when(authService.authenticate(any(LoginRequest.class)))
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
        when(authService.authenticate(any(LoginRequest.class))).thenReturn(respuestaTokenCorto);

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

// === ARCHIVO: src/test/java/com/bancadigital/controller/ClienteControllerTest.java ===
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
        when(clienteService.listarClientes(any(Pageable.class))).thenReturn(pagina);

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
        when(clienteService.actualizarCliente(eq(1L), any(ClienteDTO.class))).thenReturn(Optional.of(clienteDTOPrueba));

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
        when(clienteService.eliminarCliente(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/clientes/{id} - Cliente inexistente retorna 404")
    @WithMockUser(roles = "ADMIN")
    void eliminarCliente_clienteInexistente_retorna404() throws Exception {
        when(clienteService.eliminarCliente(999L)).thenReturn(false);

        mockMvc.perform(delete("/api/clientes/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/clientes - Con paginacion retorna resultados correctos")
    @WithMockUser(roles = "USER")
    void listarClientes_conPaginacion_retornaResultados() throws Exception {
        List<ClienteDTO> clientes = Arrays.asList(clienteDTOPrueba, clienteDTOPrueba);
        Page<ClienteDTO> pagina = new PageImpl<>(clientes);
        when(clienteService.listarClientes(any(Pageable.class))).thenReturn(pagina);

        mockMvc.perform(get("/api/clientes")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.totalElements").value(2));
    }
}

// === ARCHIVO: src/test/java/com/bancadigital/security/JwtTokenUtilTest.java ===
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
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.length() > 0);
    }

    @Test
    @DisplayName("Generar token contiene el username en los claims")
    void generateToken_contieneUsernameEnClaims() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

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
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

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
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

        String usernameExtraido = jwtTokenUtil.extractUsername(token);

        assertEquals(USERNAME, usernameExtraido);
    }

    @Test
    @DisplayName("Extraer userId del token retorna valor correcto")
    void extractUserId_tokenValido_retornaUserId() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

        Long userIdExtraido = jwtTokenUtil.extractUserId(token);

        assertEquals(USER_ID, userIdExtraido);
    }

    @Test
    @DisplayName("Validar token valido retorna true")
    void validateToken_tokenValido_retornaTrue() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

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
        String tokenValido = jwtTokenUtil.generateToken(USERNAME, USER_ID);
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
        assertThrows(NullPointerException.class, () -> jwtTokenUtil.extractUsername(null));
    }

    @Test
    @DisplayName("Verificar expiracion de token retorna false para token valido")
    void isTokenExpired_tokenValido_retornaFalse() {
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

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
        String token = jwtTokenUtil.generateToken(USERNAME, USER_ID);

        Date fechaExpiracion = jwtTokenUtil.getExpirationDate(token);

        assertNotNull(fechaExpiracion);
        assertTrue(fechaExpiracion.after(new Date()));
    }

    @Test
    @DisplayName("Tokens diferentes generan valores diferentes")
    void generateToken_diferentesUsuarios_generaTokensDistintos() {
        String token1 = jwtTokenUtil.generateToken("usuario1@banca.com", 1L);
        String token2 = jwtTokenUtil.generateToken("usuario2@banca.com", 2L);

        assertNotEquals(token1, token2);
    }

    @Test
    @DisplayName("Mismo usuario genera tokens diferentes por timestamp")
    void generateToken_mismoUsuario_generaTokensDistintos() throws InterruptedException {
        String token1 = jwtTokenUtil.generateToken(USERNAME, USER_ID);
        Thread.sleep(10);
        String token2 = jwtTokenUtil.generateToken(USERNAME, USER_ID);

        assertNotEquals(token1, token2);
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/dto/ClienteDTO.java ===
package com.bancadigital.dto;

import com.bancadigital.model.Cliente;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ClienteDTO(
    Long id,
    String nombre,
    String apellido,
    String email,
    String telefono,
    String direccion,
    String numeroIdentificacion,
    BigDecimal saldo,
    LocalDate fechaRegistro,
    boolean activo
) {
    public ClienteDTO {
        if (email != null && !email.isBlank()) {
            email = email.trim().toLowerCase();
        }
        if (numeroIdentificacion != null) {
            numeroIdentificacion = numeroIdentificacion.trim().toUpperCase();
        }
    }
    
    public static ClienteDTO fromEntity(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        return new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getNumeroIdentificacion(),
            cliente.getSaldo(),
            cliente.getFechaRegistro(),
            cliente.isActivo()
        );
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public boolean tieneSaldoDisponible() {
        return saldo != null && saldo.compareTo(BigDecimal.ZERO) > 0;
    }
    
    public String getEmailEnmascarado() {
        if (email == null || !email.contains("@")) {
            return "N/A";
        }
        String[] partes = email.split("@");
        String usuario = partes[0];
        String dominio = partes[1];
        if (usuario.length() <= 2) {
            return "**@" + dominio;
        }
        return usuario.substring(0, 2) + "***@" + dominio;
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/security/JwtAuthenticationFilter.java ===
package com.bancadigital.security;

import com.bancadigital.exception.JwtAuthenticationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final int BEARER_PREFIX_LENGTH = 7;

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil,
                                   UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = extractJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && jwtTokenUtil.validateToken(jwt)) {
                String email = jwtTokenUtil.extractEmail(jwt);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                    if (jwtTokenUtil.validateToken(jwt, userDetails.getUsername())) {
                        UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                            );
                        authentication.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                        );

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (JwtAuthenticationException e) {
            logger.error("Error de autenticación JWT: " + e.getMessage(), e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Token JWT inválido o expirado\"}");
            return;
        } catch (Exception e) {
            logger.error("Error inesperado en filtro JWT: " + e.getMessage(), e);
        }

        filterChain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX_LENGTH);
        }

        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/api/auth/") ||
               path.startsWith("/h2-console/") ||
               path.startsWith("/actuator/");
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/controller/AuthController.java ===
package com.bancadigital.controller;

import com.bancadigital.dto.LoginRequest;
import com.bancadigital.dto.LoginResponse;
import com.bancadigital.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (!request.hasCredentials()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Credenciales incompletas", "mensaje", "Se requiere email y password"));
        }

        try {
            LoginResponse response = authService.autenticar(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Autenticación fallida", "mensaje", e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Token requerido", "mensaje", "Se requiere un token válido en el header Authorization"));
        }

        String token = authHeader.substring(7);
        try {
            LoginResponse response = authService.verificarYRenovarToken(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Token inválido", "mensaje", e.getMessage()));
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validarToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("valido", false, "mensaje", "Token no proporcionado"));
        }

        String token = authHeader.substring(7);
        boolean valido = authService.validarToken(token);

        if (valido) {
            return ResponseEntity.ok(Map.of("valido", true, "mensaje", "Token vigente"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("valido", false, "mensaje", "Token expirado o inválido"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "No hay sesión activa"));
        }

        String token = authHeader.substring(7);
        authService.invalidarToken(token);
        return ResponseEntity.ok(Map.of("mensaje", "Sesión cerrada exitosamente"));
    }
}

// === ARCHIVO: src/main/java/com/bancadigital/service/AuthService.java ===
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

// === ARCHIVO: src/test/java/com/bancadigital/controller/AuthControllerTest.java ===
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

// === ARCHIVO: src/test/java/com/bancadigital/controller/ClienteControllerTest.java ===
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

// === ARCHIVO: src/test/java/com/bancadigital/security/JwtTokenUtilTest.java ===
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
```
