package com.inventario.controller;

import java.util.List;

import com.inventario.model.Producto;
import com.inventario.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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



@RestController
@CrossOrigin
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("/listar")
	public ResponseEntity< List<Producto>> listarProductos() {
		return ResponseEntity.ok(productoService.listarProducto());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(productoService.buscarProductoPorId(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Producto> crearProducto(@RequestBody @Valid Producto producto) {
		try {
			Producto productoCreado = productoService.crearProducto(producto);
			return ResponseEntity.ok(productoCreado);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> editarProducto(@PathVariable Long id, @RequestBody @Valid Producto producto) {
		try {
			Producto productoExistente = productoService.buscarProductoPorId(id);
			
			if (producto.getNombre() != null && !producto.getNombre().isEmpty())
				productoExistente.setNombre(producto.getNombre());
			
			if (producto.getDescripcion() != null && !producto.getDescripcion().isEmpty())
				productoExistente.setDescripcion(producto.getDescripcion());

			productoExistente.setPreciocosto(producto.getPreciocosto());
			productoExistente.setPrecioventa(producto.getPrecioventa());
			productoExistente.setDisponible(producto.isDisponible());


			productoService.actualizarProducto(productoExistente);
			
			return ResponseEntity.ok(productoExistente);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> eliminarproducto(@PathVariable Long id) {
		try {
			Producto productoEliminar = productoService.buscarProductoPorId(id);
			productoService.eliminarProducto(id);
			return ResponseEntity.ok(productoEliminar);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
