# Prueba Técnica QA - Sauce Demo

## Descripción del Proyecto
Proyecto de automatización de pruebas para la página web [Sauce Demo](https://www.saucedemo.com/) implementando:
- Framework Serenity BDD
- Patrón de diseño Screenplay
- Cucumber para BDD
- Integración con Selenium WebDriver

## Escenarios Automatizados
### 1. Login
- Login exitoso con credenciales válidas
- Login fallido con credenciales inválidas
- Validación de mensajes de error

### 2. Carrito de Compras
- Agregar un producto al carrito
- Agregar múltiples productos
- Validación del contador del carrito

### 3. Proceso de Checkout
- Completar proceso de compra exitosamente
- Validación de formulario de información
- Confirmación de orden

## Pre-requisitos
- Java 11 o superior
- Maven 3.6.3 o superior
- Google Chrome (última versión)
- Conexión a Internet

## Estructura del Proyecto
```
src/
├── main/java/com/pruebatecnicaqa/
│   ├── tasks/           # Tareas del patrón Screenplay
│   ├── questions/       # Preguntas para validaciones
│   ├── userinterfaces/  # Page Objects y localizadores
│   ├── interactions/    # Interacciones personalizadas
│   └── utils/          # Utilidades y helpers
└── test/
    ├── java/com/pruebatecnicaqa/
    │   ├── runners/     # Runners de Cucumber
    │   └── stepdefinitions/  # Definiciones de pasos
    └── resources/
        └── features/    # Archivos .feature
```

## Instalación y Ejecución
1. Clonar el repositorio:
   ```bash
   git clone [URL_DEL_REPO]
   cd PruebaTecnicaQA
   ```

2. Instalar dependencias:
   ```bash
   mvn clean install
   ```

3. Ejecutar las pruebas:
   ```bash
   mvn clean verify
   ```

## Reportes
Los reportes de Serenity se generan en:
- `target/site/serenity/index.html`

Incluyen:
- Dashboard general
- Desglose por features
- Screenshots de pasos críticos
- Métricas de ejecución

## Pruebas de Performance
Las pruebas de rendimiento se encuentran en la carpeta `performance-test/`.
Ver [README de Performance](performance-test/README.md) para más detalles.

## Configuración
### serenity.properties
```properties
webdriver.driver=chrome
serenity.project.name=Prueba Tecnica QA
serenity.take.screenshots=AFTER_EACH_STEP
```

## Dependencias Principales
- Serenity BDD Core: 3.9.8
- Serenity Cucumber: 3.9.8
- Selenium WebDriver: 4.10.0
- WebDriverManager: 5.4.1
- JUnit: 4.13.2

## Buenas Prácticas Implementadas
1. Patrón Screenplay para mejor mantenibilidad
2. Page Objects para gestión de elementos UI
3. Cucumber para especificaciones ejecutables
4. Screenshots automáticos en pasos críticos
5. Manejo de esperas explícitas
6. Reportes detallados con Serenity

## Mejoras Futuras
- [ ] Soporte para múltiples navegadores
- [ ] Ejecución en paralelo
- [ ] Integración con CI/CD
- [ ] Pruebas de API
- [ ] Dockerización del proyecto

## Autor
[Tu Nombre]

## Notas Adicionales
- Las pruebas están optimizadas para Chrome
- Se incluyen pruebas de performance separadas
- Los datos de prueba están parametrizados
