package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventario.model.Inventario;
@Repository
public interface IInventarioRepository extends JpaRepository<Inventario,Long> {
    // aquí definir métodos adicionales para el repositorio
}
