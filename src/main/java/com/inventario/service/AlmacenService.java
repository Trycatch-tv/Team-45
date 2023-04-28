package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.Almacen;
import com.inventario.repository.IAlmacenRepository;

@Service
public class AlmacenService {
	
	private final IAlmacenRepository almacenRepository;

	@Autowired
	public AlmacenService(IAlmacenRepository almacenRepository) {
		this.almacenRepository = almacenRepository;
	}

	public List<Almacen> listarAlmacenes() {
		return almacenRepository.findAll();
	}
	
	public Almacen buscarAlmacenPorId(Long id) {
		return almacenRepository.findById(id).get();
	}
	
	public Almacen crearAlmacen(Almacen almacen) {
		return almacenRepository.save(almacen);
	}
	
	public Almacen actualizarAlmacen(Almacen almacen) {
		return almacenRepository.save(almacen);
	}
	
	public void eliminarAlmacen(Long id) {
		almacenRepository.deleteById(id);
	}
	
}
