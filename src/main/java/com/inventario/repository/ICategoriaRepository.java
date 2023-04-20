package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    // aquí definir métodos adicionales para el repositorio
}
