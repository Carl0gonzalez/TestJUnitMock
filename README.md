# 🧪 calculadora-pedidos — Pruebas Unitarias con JUnit 5 y Mockito

Proyecto Java que implementa una calculadora de pedidos con descuentos, desarrollado como ejercicio de **pruebas unitarias** con JUnit 5, Mockito y GitHub Actions CI.

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk) ![Maven](https://img.shields.io/badge/Maven-3.x-orange?logo=apachemaven) ![JUnit5](https://img.shields.io/badge/JUnit-5.10-green?logo=junit5) ![Mockito](https://img.shields.io/badge/Mockito-5.12-blue)

---

## 📋 Descripción

Aplicación de backend que calcula el total de un pedido aplicando descuentos y cargos por envío express. El proyecto pone énfasis en la **calidad del código** mediante pruebas unitarias con dobles de prueba (mocks).

### Funcionalidades
- Cálculo de total de pedido con porcentaje de descuento
- Soporte para envío express con cargo adicional
- Obtención de descuentos por código mediante repositorio (mockeable)
- CI/CD automatizado con GitHub Actions

---

## 🏗️ Estructura del proyecto

```
calculadora-pedidos/
├── src/
│   ├── main/java/com/ejemplo/
│   │   ├── PedidoService.java          # Lógica de negocio principal
│   │   └── DescuentoRepository.java   # Interfaz del repositorio de descuentos
│   └── test/java/com/ejemplo/
│       ├── PedidoServiceTest.java      # Tests unitarios clásicos
│       └── PedidoServiceMockTest.java  # Tests con Mockito
├── .github/workflows/test.yml          # Pipeline de CI
├── pom.xml
└── README.md
```

---

## 🛠️ Tecnologías

| Herramienta | Versión | Rol |
|---|---|---|
| Java | 17 | Lenguaje principal |
| Maven | 3.x | Build y gestión de dependencias |
| JUnit Jupiter | 5.10.0 | Framework de testing |
| Mockito | 5.12.0 | Mocking de dependencias |
| GitHub Actions | — | Integración continua |

---

## 🚀 Cómo ejecutar

### Prerrequisitos
- Java JDK 17+
- Maven 3.x
- Git

### Pasos

```bash
# 1. Clonar el repositorio
git clone https://github.com/Carl0gonzalez/TestJUnitMock.git
cd TestJUnitMock

# 2. Compilar y ejecutar todos los tests
mvn clean test

# 3. Ver reporte de resultados
cat target/surefire-reports/*.txt
```

---

## 🤖 Integración Continua

Los tests se ejecutan automáticamente en GitHub Actions al hacer **push** o abrir un **Pull Request**. Ver configuración en `.github/workflows/test.yml`.

---

## 🪝 Git Hook: validar antes del commit

Para asegurarte de que nunca se commitee código con tests fallidos:

```bash
# Crear el hook pre-commit
cat > .git/hooks/pre-commit << 'EOF'
#!/bin/sh
echo "Ejecutando tests antes del commit..."
mvn test
if [ $? -ne 0 ]; then
  echo "🚫 Tests fallaron — commit cancelado."
  exit 1
fi
EOF
chmod +x .git/hooks/pre-commit
```

---

## 💡 Aprendizajes clave

- Separación entre lógica de negocio y dependencias externas mediante inyección de dependencias
- Uso de `@Mock` y `when(...).thenReturn(...)` para simular comportamiento de repositorios
- Refactorización segura respaldada por tests automatizados
- Estrategia de CI para validar calidad en cada push

---

## 👤 Autor

**Carlo González** — [GitHub](https://github.com/Carl0gonzalez)
