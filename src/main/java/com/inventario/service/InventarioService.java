package com.inventario.service;



import org.springframework.beans.factory.annotation.Autowired;
import com.inventario.repository.IInventarioRepository;
import com.inventario.model.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventarioService {

    @Autowired
    private IInventarioRepository inventarioRepository;

    public List<Inventario> listarInventarioes() {
        return inventarioRepository.findAll();
    }

    public Inventario buscarInventarioPorId(Long id) {
        return inventarioRepository.findById(id).get();
    }

    public Inventario crearInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario actualizarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }


}
