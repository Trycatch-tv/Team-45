package com.inventario.service;

import com.inventario.model.InventarioProducto;
import com.inventario.repository.IInventarioProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InventarioProductoService {

    @Autowired
    private IInventarioProductoRepository InventarioProductoRepository;

    public List<InventarioProducto> listarInventarioProductos() {

        return InventarioProductoRepository.findAll();
    }

    public InventarioProducto buscarInventarioProductoPorId(Long id) {

        return InventarioProductoRepository.findById(id).get();
    }

    public InventarioProducto crearInventarioProducto(InventarioProducto inventarioProducto) {

        return InventarioProductoRepository.save(inventarioProducto);
    }

    public InventarioProducto actualizarInventarioProducto(InventarioProducto inventarioProducto) {

        return InventarioProductoRepository.save(inventarioProducto);
    }

    public void eliminarInventarioProducto(Long id) {

        InventarioProductoRepository.deleteById(id);
    }
}

