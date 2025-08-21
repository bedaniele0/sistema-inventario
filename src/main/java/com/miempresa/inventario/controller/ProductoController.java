package com.miempresa.inventario.controller;

import com.miempresa.inventario.entity.Producto;
import com.miempresa.inventario.dto.ProductoDTO;
import com.miempresa.inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "¡API de Inventario Profesional!");
        response.put("version", "2.0.0");
        response.put("endpoints", Map.of(
            "productos", "/api/productos",
            "buscar", "/api/productos/buscar?q=termino",
            "bajo-stock", "/api/productos/bajo-stock",
            "estadisticas", "/api/dashboard"
        ));
        return response;
    }
    
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/productos")
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO dto) {
        try {
            Producto nuevo = service.crear(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        try {
            Producto actualizado = service.actualizar(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/productos/buscar")
    public List<Producto> buscarProductos(@RequestParam("q") String termino) {
        return service.buscar(termino);
    }
    
    @GetMapping("/productos/bajo-stock")
    public List<Producto> productosBajoStock() {
        return service.obtenerBajoStock();
    }
    
    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        return service.obtenerEstadisticas();
    }
}
