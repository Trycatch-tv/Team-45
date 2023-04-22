package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.model.Almacen;

@Repository
public interface IAlmacenRepository extends JpaRepository<Almacen, Long> {
    // aquí definir métodos adicionales para el repositorio
}
