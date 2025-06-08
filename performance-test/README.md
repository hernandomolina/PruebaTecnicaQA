# Pruebas de Performance - JSONPlaceholder API

## Entregables
1. **Script de Pruebas**
   - Ubicación: `/scripts/jsonplaceholder_test.jmx`
   - Herramienta: Apache JMeter
   - Tipo: Prueba de carga concurrente

2. **Evidencia de Ejecución**
   - Reporte HTML: `/reports/html/index.html`
   - Resultados detallados: `/reports/results.jtl`

3. **Resumen de Hallazgos**
   - Documento detallado: `/docs/findings.md`

## Objetivo y Alcance
- **API Objetivo:** https://jsonplaceholder.typicode.com/posts
- **Endpoint:** GET /posts
- **Usuarios Concurrentes:** 100
- **Duración:** 10 segundos (con ramp-up configurado)

## Resultados Principales
### Métricas de Rendimiento
| Métrica | Valor |
|---------|-------|
| Total de peticiones | 100 |
| Tiempo promedio | 178 ms |
| Tiempo máximo | 383 ms |
| Tiempo mínimo | 131 ms |
| Desviación estándar | 36.98 ms |
| Porcentaje de errores | 0.00% |
| Throughput | 10.0 req/seg |
| Tamaño medio de respuesta | 28,867 bytes |

### Análisis de Resultados
1. **Capacidad de Carga**
   - El endpoint soportó exitosamente la carga de 100 usuarios concurrentes
   - No se registraron errores durante la ejecución
   - Los tiempos de respuesta se mantuvieron estables

2. **Hallazgos**
   - Tiempo de respuesta promedio dentro de rangos aceptables
   - Desviación estándar baja, indicando consistencia
   - Sin errores registrados

## Recomendaciones
1. Simular variaciones en los headers (Authorization, User-Agent)
2. Escalar pruebas a 500-1000 usuarios en entorno productivo
3. Incluir pruebas de otros métodos HTTP (POST, PUT, DELETE)

## Instrucciones de Ejecución
1. Abrir Apache JMeter
2. Cargar el script desde `/scripts/jsonplaceholder_test.jmx`
3. Configurar el número de usuarios si se desea modificar
4. Ejecutar la prueba
5. Los resultados se generarán en la carpeta `/reports`


