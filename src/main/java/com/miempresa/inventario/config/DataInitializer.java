package com.miempresa.inventario.config;

import com.miempresa.inventario.entity.Producto;
import com.miempresa.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductoRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("🌱 Creando datos de ejemplo...");
            
            Producto p1 = new Producto();
            p1.setCodigo("LAPTOP001");
            p1.setNombre("Laptop Dell Inspiron");
            p1.setDescripcion("Laptop para desarrollo con 16GB RAM");
            p1.setPrecio(new BigDecimal("15000.00"));
            p1.setStock(10);
            p1.setStockMinimo(3);
            p1.setCategoria("Electrónica");
            repository.save(p1);
            
            Producto p2 = new Producto();
            p2.setCodigo("MOUSE001");
            p2.setNombre("Mouse Logitech MX");
            p2.setDescripcion("Mouse inalámbrico ergonómico");
            p2.setPrecio(new BigDecimal("1200.00"));
            p2.setStock(2); // Bajo stock!
            p2.setStockMinimo(5);
            p2.setCategoria("Accesorios");
            repository.save(p2);
            
            Producto p3 = new Producto();
            p3.setCodigo("MONITOR001");
            p3.setNombre("Monitor Samsung 27\"");
            p3.setDescripcion("Monitor 4K para diseño");
            p3.setPrecio(new BigDecimal("8000.00"));
            p3.setStock(7);
            p3.setStockMinimo(2);
            p3.setCategoria("Electrónica");
            repository.save(p3);
            
            System.out.println("✅ Datos de ejemplo creados!");
        }
    }
}
