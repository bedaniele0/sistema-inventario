# 📦 Sistema de Inventario

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Gradle](https://img.shields.io/badge/Gradle-8.5-blue.svg)](https://gradle.org/)
[![H2 Database](https://img.shields.io/badge/H2-Database-yellow.svg)](https://www.h2database.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Sistema profesional de gestión de inventario desarrollado con Spring Boot 3.5.5 - API REST completa con H2 Database

## 🚀 Demo en Vivo

> 🔜 Próximamente disponible en Heroku/Railway

## 📸 Screenshots

<div align="center">
  <img src="screenshots/swagger-ui.png" alt="Swagger UI" width="45%">
  <img src="screenshots/api-response.png" alt="API Response" width="45%">
</div>

## ✨ Características

### 📊 Gestión de Inventario
- **CRUD Completo** de productos con validaciones
- **Control de Stock** en tiempo real
- **Alertas Automáticas** cuando el stock está bajo
- **Categorización** de productos

### 📈 Dashboard Analítico
- Métricas en tiempo real
- Total de productos y categorías
- Valor total del inventario
- Productos con stock bajo

### 🔧 Características Técnicas
- **API RESTful** con 9 endpoints documentados
- **Base de datos H2** embebida (desarrollo)
- **Swagger UI** para documentación interactiva
- **DTOs** para transferencia de datos
- **Manejo de excepciones** centralizado
- **Datos de prueba** automáticos

## 🛠️ Tecnologías Utilizadas

- **Backend Framework:** Spring Boot 3.5.5
- **Lenguaje:** Java 17
- **Base de Datos:** H2 (desarrollo) / PostgreSQL (producción ready)
- **Build Tool:** Gradle 8.5
- **Documentación API:** OpenAPI 3.0 (Swagger)
- **Testing:** JUnit 5, Mockito

## 📋 Prerequisitos

- Java 17 o superior
- Gradle 8.5 o superior (opcional, incluye wrapper)

## 🔧 Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/bedaniele0/sistema-inventario.git
cd sistema-inventario
```

2. **Ejecutar la aplicación**
```bash
./gradlew bootRun
```

3. **Acceder a la aplicación**
- API Base: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console

## 📚 Documentación API

### Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| GET | `/api/productos/{id}` | Obtener producto por ID |
| POST | `/api/productos` | Crear nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar producto |
| DELETE | `/api/productos/{id}` | Eliminar producto |
| GET | `/api/productos/buscar` | Buscar productos |
| GET | `/api/productos/bajo-stock` | Productos con stock bajo |
| GET | `/api/dashboard/metricas` | Métricas del dashboard |

### Ejemplo de Request/Response

**POST** `/api/productos`
```json
{
  "nombre": "Laptop Dell XPS",
  "descripcion": "Laptop de alto rendimiento",
  "precio": 25999.99,
  "stock": 15,
  "stockMinimo": 5,
  "categoria": "Electrónica"
}
```

**Response**
```json
{
  "id": 1,
  "nombre": "Laptop Dell XPS",
  "descripcion": "Laptop de alto rendimiento",
  "precio": 25999.99,
  "stock": 15,
  "stockMinimo": 5,
  "categoria": "Electrónica",
  "fechaCreacion": "2025-08-21T10:30:00",
  "fechaActualizacion": "2025-08-21T10:30:00"
}
```

## 🗄️ Base de Datos

### H2 Console Access
- **URL:** `jdbc:h2:mem:inventariodb`
- **Usuario:** `sa`
- **Password:** (dejar en blanco)

### Datos de Ejemplo
El sistema incluye datos de prueba que se cargan automáticamente:
- 4 categorías predefinidas
- 10 productos de ejemplo
- Configuración de alertas

## 🧪 Testing

```bash
# Ejecutar tests
./gradlew test

# Generar reporte de cobertura
./gradlew jacocoTestReport
```

## 📦 Deployment

### Docker (Próximamente)
```dockerfile
FROM openjdk:17-jdk-slim
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

### Variables de Entorno
```properties
# Producción con PostgreSQL
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/inventario
SPRING_DATASOURCE_USERNAME=usuario
SPRING_DATASOURCE_PASSWORD=password
```

## 🤝 Contribuciones

Las contribuciones son bienvenidas! Por favor:

1. Fork el proyecto
2. Crea tu feature branch (`git checkout -b feature/NuevaCaracteristica`)
3. Commit tus cambios (`git commit -m 'Agregar nueva característica'`)
4. Push a la branch (`git push origin feature/NuevaCaracteristica`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**Daniel Varela**
- GitHub: [@bedaniele0](https://github.com/bedaniele0)
- LinkedIn: [Tu LinkedIn](https://linkedin.com/in/tu-perfil)

## 🙏 Agradecimientos

- Spring Boot Documentation
- Baeldung Tutorials
- Stack Overflow Community

---

⭐ Si este proyecto te ha sido útil, considera darle una estrella!
