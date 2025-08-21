# 📦 Sistema de Inventario - API REST

> Sistema profesional de gestión de inventario desarrollado con Spring Boot 3.5.5

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## 🚀 Características

- ✅ **API REST completa** con operaciones CRUD
- ✅ **Base de datos H2** en memoria para desarrollo
- ✅ **Búsqueda inteligente** de productos
- ✅ **Alertas de stock bajo** automáticas
- ✅ **Dashboard** con estadísticas en tiempo real
- ✅ **Manejo de excepciones** global
- ✅ **Validación de datos** con Bean Validation
- ✅ **CORS habilitado** para integración con frontend

## 🛠️ Tecnologías

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **H2 Database**
- **Gradle**
- **Lombok** (opcional)

## 📋 Prerrequisitos

- Java 17 o superior
- Gradle 7.x o superior

## 🔧 Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/sistema-inventario.git
cd sistema-inventario
```

2. Ejecuta la aplicación:
```bash
./gradlew bootRun
```

La aplicación estará disponible en `http://localhost:8080`

## 📡 API Endpoints

### Información de la API
```
GET /api/
```

### Productos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| GET | `/api/productos/{id}` | Obtener producto por ID |
| POST | `/api/productos` | Crear nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar producto |
| DELETE | `/api/productos/{id}` | Eliminar producto |
| GET | `/api/productos/buscar?q={termino}` | Buscar productos |
| GET | `/api/productos/bajo-stock` | Productos con stock bajo |

### Dashboard
```
GET /api/dashboard
```

## 💾 Base de Datos

### Acceso a H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:inventariodb`
- Usuario: `sa`
- Contraseña: (vacío)

### Esquema de Producto

```java
{
  "id": 1,
  "codigo": "PROD001",
  "nombre": "Laptop Dell Inspiron",
  "descripcion": "Laptop para desarrollo",
  "precio": 15000.00,
  "stock": 10,
  "stockMinimo": 3,
  "categoria": "Electrónica",
  "activo": true,
  "fechaCreacion": "2025-08-21T12:00:00",
  "fechaActualizacion": "2025-08-21T12:00:00"
}
```

## 🧪 Ejemplos de Uso

### Crear un producto
```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "codigo": "TABLET001",
    "nombre": "iPad Pro",
    "descripcion": "Tablet profesional",
    "precio": 25000.00,
    "stock": 5,
    "stockMinimo": 2,
    "categoria": "Electrónica"
  }'
```

### Buscar productos
```bash
curl http://localhost:8080/api/productos/buscar?q=laptop
```

### Ver dashboard
```bash
curl http://localhost:8080/api/dashboard
```

## 📊 Estructura del Proyecto

```
sistema-inventario/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/miempresa/inventario/
│   │   │       ├── config/
│   │   │       │   └── DataInitializer.java
│   │   │       ├── controller/
│   │   │       │   └── ProductoController.java
│   │   │       ├── dto/
│   │   │       │   └── ProductoDTO.java
│   │   │       ├── entity/
│   │   │       │   └── Producto.java
│   │   │       ├── repository/
│   │   │       │   └── ProductoRepository.java
│   │   │       ├── service/
│   │   │       │   └── ProductoService.java
│   │   │       └── SistemaInventarioApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── build.gradle
```

## 🚀 Próximas Mejoras

- [ ] Implementar autenticación JWT
- [ ] Agregar paginación
- [ ] Integrar con PostgreSQL para producción
- [ ] Agregar Swagger UI para documentación
- [ ] Implementar caché con Redis
- [ ] Agregar tests unitarios e integración

## 👨‍💻 Autor

**Daniel Varela**
- LinkedIn: [tu-perfil]
- GitHub: [@tu-usuario]

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub!