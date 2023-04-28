package com.inventario.controller;

import java.util.List;
import java.util.Optional;

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

import com.inventario.model.Almacen;
import com.inventario.service.AlmacenService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/almacen")
public class AlmacenController {
	
	private final AlmacenService almacenService;

	@Autowired
	public AlmacenController(AlmacenService almacenService) {
		this.almacenService = almacenService;
	}

	@GetMapping
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
	
	@PostMapping
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
			
			if (almacen.getNombreAlmacen() != null && !almacen.getNombreAlmacen().isEmpty())
				almacenExistente.setNombreAlmacen(almacen.getNombreAlmacen());
			
			if (almacen.getTelefonoAlmacen() != null && !almacen.getTelefonoAlmacen().isEmpty())
				almacenExistente.setTelefonoAlmacen(almacen.getTelefonoAlmacen());
			
			if (almacen.getEmailAlmacen() != null && !almacen.getEmailAlmacen().isEmpty())
				almacenExistente.setEmailAlmacen(almacen.getEmailAlmacen());
			
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
