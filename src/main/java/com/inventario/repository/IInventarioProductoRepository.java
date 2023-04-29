package com.inventario.repository;

import com.inventario.model.InventarioProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventarioProductoRepository extends JpaRepository<InventarioProducto,Long> {
    // aquí definir métodos adicionales para el repositorio
}
