package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventario.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {

}
