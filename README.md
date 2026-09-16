# Implementación de autenticación JWT en una API REST

El equipo de desarrollo necesita fortalecer sus habilidades en la implementación de autenticación JWT en una API REST para asegurar que los servicios sean seguros y robustos. La API REST se utiliza para gestionar solicitudes de clientes en una plataforma de banca digital. Los clientes autenticados pueden realizar operaciones como consultas de saldo, transferencias y solicitudes de préstamo. Es crucial que la autenticación sea segura y eficiente para mantener la confianza de los usuarios y cumplir con las regulaciones financieras.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | seguridad-en-api-rest |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del entorno de desarrollo

**Objetivo:** Preparar el entorno de desarrollo para implementar la autenticación JWT.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar y configurar las herramientas necesarias para el desarrollo de la API REST con autenticación JWT.
- Asegurar que el entorno de desarrollo esté preparado para la implementación de la autenticación.

**Entregable:** Entorno de desarrollo configurado y listo para la implementación de la autenticación JWT.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las mejores prácticas para configurar el entorno de desarrollo.
- Investiga sobre las herramientas y librerías que pueden facilitar la implementación de la autenticación JWT.

</details>

### Fase 2: Implementación de la autenticación JWT

**Objetivo:** Implementar la autenticación JWT en la API REST.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Diseñar y desarrollar el flujo de autenticación JWT para la API REST.
- Asegurar que los tokens JWT se generen y validen correctamente.
- Implementar la lógica para manejar las solicitudes autenticadas.

**Entregable:** API REST con autenticación JWT implementada y funcionando.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los diferentes métodos para generar y validar tokens JWT.
- Investiga sobre las mejores prácticas para manejar la autenticación en una API REST.

</details>

### Fase 3: Pruebas y optimización

**Objetivo:** Realizar pruebas y optimizar la implementación de la autenticación JWT.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Realizar pruebas unitarias y de integración para asegurar la correcta funcionalidad de la autenticación JWT.
- Identificar y corregir posibles errores o ineficiencias en la implementación.
- Optimizar el rendimiento y la seguridad de la autenticación.

**Entregable:** API REST con autenticación JWT optimizada y con pruebas unitarias y de integración realizadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera diferentes escenarios de prueba para asegurar la robustez de la autenticación.
- Investiga sobre técnicas de optimización para mejorar el rendimiento y la seguridad de la autenticación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es la autenticación JWT y por qué es importante en una API REST?
- **paraQueSirve**: ¿Para qué sirve la autenticación JWT en el contexto de una API REST de banca digital?
- **comoSeUsa**: ¿Cómo se implementa la autenticación JWT en una API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar la autenticación JWT y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones importantes hay que tomar al implementar la autenticación JWT en una API REST?

## Criterios de Evaluacion

- Implementación correcta de la autenticación JWT en la API REST.
- Pruebas unitarias y de integración realizadas para asegurar la robustez de la autenticación.
- Optimización del rendimiento y la seguridad de la autenticación.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
