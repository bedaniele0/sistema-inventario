package com.miempresa.inventario.service;

import com.miempresa.inventario.entity.Producto;
import com.miempresa.inventario.dto.ProductoDTO;
import com.miempresa.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

@Service
@Transactional
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    public List<Producto> obtenerTodos() {
        return repository.findByActivoTrue();
    }
    
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }
    
    public Optional<Producto> obtenerPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }
    
    public Producto crear(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setCategoria(dto.getCategoria());
        
        return repository.save(producto);
    }
    
    public Producto actualizar(Long id, ProductoDTO dto) {
        Producto producto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setCategoria(dto.getCategoria());
        producto.setFechaActualizacion(LocalDateTime.now());
        
        return repository.save(producto);
    }
    
    public void eliminar(Long id) {
        Producto producto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setActivo(false);
        repository.save(producto);
    }
    
    public List<Producto> buscar(String termino) {
        return repository.buscarProductos(termino);
    }
    
    public List<Producto> obtenerBajoStock() {
        return repository.findProductosBajoStock();
    }
    
    public Map<String, Object> obtenerEstadisticas() {
        List<Producto> productos = repository.findByActivoTrue();
        Map<String, Object> stats = new HashMap<>();
        
        stats.put("totalProductos", productos.size());
        stats.put("productosBajoStock", repository.findProductosBajoStock().size());
        
        BigDecimal valorTotal = productos.stream()
            .map(p -> p.getPrecio().multiply(new BigDecimal(p.getStock())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        stats.put("valorInventario", valorTotal);
        
        return stats;
    }
}
