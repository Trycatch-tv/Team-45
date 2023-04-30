package com.inventario.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.aspectj.bridge.IMessageContext;
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

import com.inventario.model.Almacen;
import com.inventario.service.AlmacenService;

@RestController
@CrossOrigin
@RequestMapping("/api/almacen")
public class AlmacenController {
	
	//@Autowired
	private final AlmacenService almacenService;

	public AlmacenController ( AlmacenService almacenService){
		this.almacenService = almacenService;
	}
	@GetMapping("/")
	public ResponseEntity<List<Almacen>> listarAlmacenes() {
		return ResponseEntity.ok(almacenService.listarAlmacenes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Almacen> buscarAlmacenPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(almacenService.buscarAlmacenPorId(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Almacen> crearAlmacen(@RequestBody @Valid Almacen almacen) {
		try {
			Almacen almacenCreado = almacenService.crearAlmacen(almacen);
			return ResponseEntity.ok(almacenCreado);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Almacen> editarAlmacen(@PathVariable Long id, @RequestBody @Valid Almacen almacen) {
		try {
			Almacen almacenExistente = almacenService.buscarAlmacenPorId(id);
			
			if (almacen.getNombre() != null && !almacen.getNombre().isEmpty())
				almacenExistente.setNombre(almacen.getNombre());
			
			if (almacen.getTelefono() != null && !almacen.getTelefono().isEmpty())
				almacenExistente.setTelefono(almacen.getTelefono());
			
			if (almacen.getEmail() != null && !almacen.getEmail().isEmpty())
				almacenExistente.setEmail(almacen.getEmail());
			
			almacenService.actualizarAlmacen(almacenExistente);
			
			return ResponseEntity.ok(almacenExistente);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Almacen> eliminarAlmacen(@PathVariable Long id) {
		try {
			Almacen almacenEliminar = almacenService.buscarAlmacenPorId(id);
			almacenService.eliminarAlmacen(id);
			return ResponseEntity.ok(almacenEliminar);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
