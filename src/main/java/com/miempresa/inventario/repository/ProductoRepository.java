package com.miempresa.inventario.repository;

import com.miempresa.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByCodigo(String codigo);
    
    List<Producto> findByCategoria(String categoria);
    
    List<Producto> findByActivoTrue();
    
    @Query("SELECT p FROM Producto p WHERE p.stock < p.stockMinimo")
    List<Producto> findProductosBajoStock();
    
    @Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.codigo) LIKE LOWER(CONCAT('%', :busqueda, '%'))")
    List<Producto> buscarProductos(String busqueda);
}
