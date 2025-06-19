# calculadora-pedidos

Ejercicio guiado de **Pruebas Unitarias** con JUnit 5 y Mockito en una pequeña aplicación de backend que calcula el total de un pedido.

## 🎯 Objetivos

- Comprender y aplicar pruebas unitarias.
- Escribir tests con **JUnit 5**.
- Simular dependencias con **Mockito**.
- Automatizar la ejecución de tests en **GitHub Actions**.

## 📝 Estructura del proyecto

```
calculadora-pedidos/
├── src
│   ├── main/java/com/ejemplo
│   │   ├── PedidoService.java
│   │   └── DescuentoRepository.java
│   └── test/java/com/ejemplo
│       ├── PedidoServiceTest.java
│       └── PedidoServiceMockTest.java
├── pom.xml
└── .github/workflows/test.yml
```

## 💻 Prerrequisitos

- Java JDK 17+
- Maven 3.x
- Git
- IDE a elección (IntelliJ, VS Code, Eclipse…)

## 🚀 Instalación y uso

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/calculadora-pedidos.git
   cd calculadora-pedidos
   ```
2. Compilar y ejecutar tests:
   ```bash
   mvn clean test
   ```
3. Ver el reporte de tests en `target/surefire-reports`.

## 🔀 Refactorización

- **Inyección de dependencias**: Se modificó `PedidoService.java` para recibir un `DescuentoRepository` en su constructor.
- **Firma de método**: `calcularTotal` cambió de `(double subtotal, boolean aplicaDescuento, boolean envioExpress)` a `(double subtotal, String codigoDescuento, boolean envioExpress)` para obtener el porcentaje de descuento desde el repositorio.
- **Tests actualizados**: `PedidoServiceTest.java` e `PedidoServiceMockTest.java` se adaptaron al nuevo constructor y firma.

## 🤖 Integración Continua

Las pruebas se ejecutan automáticamente en GitHub Actions definido en `.github/workflows/test.yml` al hacer **push** o **PR**.

## 💎 Git Hook: Validación antes del commit

Para asegurarte de que nunca se realice un commit si los tests fallan, agrega un hook de Git:

1. Crea el archivo `.git/hooks/pre-commit` en la raíz del proyecto con este contenido:
   ```bash
   #!/bin/sh
   echo "Ejecutando tests antes del commit..."
   mvn test
   RESULT=$?
   if [ $RESULT -ne 0 ]; then
     echo "🚫 Tests fallaron, abortando commit."
     exit 1
   fi
   ```
2. Hazlo ejecutable:
   ```bash
   chmod +x .git/hooks/pre-commit
   ```

A partir de ahora, cada vez que hagas `git commit`, se ejecutarán los tests; si alguno falla, el commit se cancelará.

## ❓ Preguntas de reflexión

1. ¿Cómo te ayudan las pruebas unitarias a detectar errores temprano?
2. ¿Qué ventajas ofrece Mockito al simular dependencias?
3. ¿Qué sucede si cambias la lógica de negocio sin actualizar los tests?
4. ¿Cómo escalarías esta estrategia a un sistema más grande?

