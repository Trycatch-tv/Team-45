package com.inventario.controller;


import com.inventario.model.Categoria;
import com.inventario.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> listarCategoria() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody @Valid Categoria categoria) {
        try {
            Categoria categoriaCreado = categoriaService.crearCategoria(categoria);
            return ResponseEntity.ok(categoriaCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editarCategoria(@PathVariable Long id, @RequestBody @Valid Categoria categoria) {
        try {
            Categoria categoriaExistente = categoriaService.buscarCategoriaPorId(id);

            if (categoria.getNombre() != null && !categoria.getNombre().isEmpty())
                categoriaExistente.setNombre(categoria.getNombre());
            if (categoria.getCodigo() != null && !categoria.getCodigo().isEmpty())
                categoriaExistente.setCodigo(categoria.getCodigo());
            if (categoria.getDescripcion() != null && !categoria.getDescripcion().isEmpty())
                categoriaExistente.setCodigo(categoria.getCodigo());

            categoriaService.actualizarCategoria(categoriaExistente);

            return ResponseEntity.ok(categoriaExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable Long id) {
        try {
            Categoria categoriaEliminar = categoriaService.buscarCategoriaPorId(id);
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok(categoriaEliminar);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
