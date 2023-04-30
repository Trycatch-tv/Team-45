package com.inventario.controller;

import com.inventario.model.InventarioProducto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventario.service.InventarioProductoService;

import java.util.List;
//hola
@RestController
@CrossOrigin
@RequestMapping("/api/inventarioProducto")
public class InventarioProductoController {

    private final InventarioProductoService inventarioProductoService;

    public InventarioProductoController (InventarioProductoService inventarioProductoService) {this.inventarioProductoService=inventarioProductoService;}



    @GetMapping("/")
    public ResponseEntity<List<InventarioProducto>> listarInventarioProducto() {
        return ResponseEntity.ok(inventarioProductoService.listarInventarioProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioProducto> buscarInventarioProductoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inventarioProductoService.buscarInventarioProductoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<InventarioProducto> crearInventarioProducto(@RequestBody @Valid InventarioProducto inventarioProducto) {
        try {
            InventarioProducto inventarioProductoCreado = inventarioProductoService.crearInventarioProducto(inventarioProducto);
            return ResponseEntity.ok(inventarioProductoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioProducto> editarInventarioProducto(@PathVariable Long id, @RequestBody @Valid InventarioProducto inventarioProducto) {
        try {
            InventarioProducto inventarioProductoExistente = inventarioProductoService.buscarInventarioProductoPorId(id);

            if (inventarioProducto.getNombre() != null && !inventarioProducto.getNombre().isEmpty())
                inventarioProductoExistente.setNombre(inventarioProducto.getNombre());
            if (inventarioProducto.getInventarioId() != null && !inventarioProducto.getInventarioId().isEmpty())
                inventarioProductoExistente.setInventarioId(inventarioProducto.getInventarioId());
            if (inventarioProducto.getProductoId() != null && !inventarioProducto.getProductoId().isEmpty())
                inventarioProductoExistente.setProductoId(inventarioProducto.getProductoId());

            inventarioProductoService.actualizarInventarioProducto(inventarioProductoExistente);

            return ResponseEntity.ok(inventarioProductoExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventarioProducto> eliminarInventarioProducto(@PathVariable Long id) {
        try {
            InventarioProducto inventarioProductoEliminar = inventarioProductoService.buscarInventarioProductoPorId(id);
            inventarioProductoService.eliminarInventarioProducto(id);
            return ResponseEntity.ok(inventarioProductoEliminar);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
