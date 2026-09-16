# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de autenticación JWT en una API REST**.

| | |
|---|---|
| Tema | seguridad-en-api-rest |
| Nivel | junior-l2 |
| Chapter | Generico |
| Especialidad | Inferido del contexto |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar con seguridad en filtro |
| Tiempo estimado | 8 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `el comando de build o arranque canonico del stack elegido` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `el comando de build o arranque canonico del stack elegido` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del entorno de desarrollo**: Entorno de desarrollo configurado y listo para la implementación de la autenticación JWT.
- **Fase 2 — Implementación de la autenticación JWT**: API REST con autenticación JWT implementada y funcionando.
- **Fase 3 — Pruebas y optimización**: API REST con autenticación JWT optimizada y con pruebas unitarias y de integración realizadas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### 2. Referencias colgando (18)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/bancadigital/controller/ClienteControllerTest.java` — `JwtAuthenticationException`
      JwtAuthenticationException se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bancadigital.exception.JwtAuthenticationException.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.listarTodos`
      Se invoca `listarTodos` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.obtenerPorId`
      Se invoca `obtenerPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.buscarPorEmail`
      Se invoca `buscarPorEmail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.buscarPorIdentificacion`
      Se invoca `buscarPorIdentificacion` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.crear`
      Se invoca `crear` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.actualizar`
      Se invoca `actualizar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.eliminar`
      Se invoca `eliminar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.activar`
      Se invoca `activar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.desactivar`
      Se invoca `desactivar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.depositar`
      Se invoca `depositar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/controller/ClienteController.java` — `ClienteService.retirar`
      Se invoca `retirar` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findAll`
      Se invoca `findAll` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findById`
      Se invoca `findById` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.findByNumeroIdentificacion`
      Se invoca `findByNumeroIdentificacion` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.save`
      Se invoca `save` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/ClienteService.java` — `ClienteRepository.countByActivo`
      Se invoca `countByActivo` sobre `ClienteRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bancadigital/service/AuthService.java` — `LoginRequest.getPassword`
      Se invoca `getPassword` sobre `LoginRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (18)

- `pom.xml`
- `src/main/java/com/bancadigital/BancaDigitalApplication.java`
- `src/main/java/com/bancadigital/dto/LoginRequest.java`
- `src/main/java/com/bancadigital/dto/LoginResponse.java`
- `src/main/java/com/bancadigital/dto/ClienteDTO.java`
- `src/main/java/com/bancadigital/model/Cliente.java`
- `src/main/java/com/bancadigital/repository/ClienteRepository.java`
- `src/main/java/com/bancadigital/config/SecurityConfig.java`
- `src/main/java/com/bancadigital/security/JwtAuthenticationFilter.java`
- `src/main/java/com/bancadigital/security/JwtTokenUtil.java`
- `src/main/java/com/bancadigital/controller/AuthController.java`
- `src/main/java/com/bancadigital/controller/ClienteController.java`
- `src/main/java/com/bancadigital/service/ClienteService.java`
- `src/main/java/com/bancadigital/service/AuthService.java`
- `src/main/java/com/bancadigital/exception/JwtAuthenticationException.java`
- `src/test/java/com/bancadigital/controller/AuthControllerTest.java`
- `src/test/java/com/bancadigital/controller/ClienteControllerTest.java`
- `src/test/java/com/bancadigital/security/JwtTokenUtilTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/bancadigital/config`
- `src/main/java/com/bancadigital/security`
- `src/main/java/com/bancadigital/controller`
- `src/main/java/com/bancadigital/dto`
- `src/main/java/com/bancadigital/model`
- `src/main/java/com/bancadigital/repository`
- `src/main/java/com/bancadigital/service`
- `src/main/java/com/bancadigital/exception`
- `src/test/java/com/bancadigital`

## Verificacion

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con seguridad en filtro**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Implementar autenticacion JWT en una API REST con Spring Security

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
