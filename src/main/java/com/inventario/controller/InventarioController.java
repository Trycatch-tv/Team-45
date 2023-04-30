package com.inventario.controller;

import com.inventario.model.Inventario;
import com.inventario.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/inventario")
public class InventarioController {
    private final InventarioService inventarioServicio;

    public InventarioController (InventarioService inventarioServicio){
        this.inventarioServicio=inventarioServicio;
    }
    @GetMapping("/")
    public ResponseEntity<List<Inventario>> listarinventarios() {
        return ResponseEntity.ok(inventarioServicio.listarInventarioes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscarInventarioPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inventarioServicio.buscarInventarioPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Inventario> crearInventario(@RequestBody @Valid Inventario inventario) {
        try {
            Inventario inventarioCreado = inventarioServicio.crearInventario(inventario);
            return ResponseEntity.ok(inventarioCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> editarInventario(@PathVariable Long id, @RequestBody @Valid Inventario inventario) {
        try {
            Inventario inventarioExistente = inventarioServicio.buscarInventarioPorId(id);

            if (inventario.getNombre() != null && !inventario.getNombre().isEmpty())
                inventarioExistente.setNombre(inventario.getNombre());

            if (inventario.getFechaApertura() != null)
                inventarioExistente.setFechaApertura(inventario.getFechaApertura());

            if (inventario.getFechaCierre() != null )
                inventarioExistente.setFechaCierre(inventario.getFechaCierre());
            if (inventario.getTotal() != null && !inventario.getTotal().isNaN())
                inventarioExistente.setTotal(inventario.getTotal());
            if (inventario.getAlmacenId() != null && !inventario.getAlmacenId().isEmpty())
                inventarioExistente.setAlmacenId(inventario.getAlmacenId());

            inventarioServicio.actualizarInventario(inventarioExistente);

            return ResponseEntity.ok(inventarioExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inventario> eliminarInventario(@PathVariable Long id) {
        try {
            Inventario inventarioEliminar = inventarioServicio.buscarInventarioPorId(id);
            inventarioServicio.eliminarInventario(id);
            return ResponseEntity.ok(inventarioEliminar);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
