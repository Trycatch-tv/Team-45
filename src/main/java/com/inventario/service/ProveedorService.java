package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventario.model.Proveedor;
import com.inventario.repository.IProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	private IProveedorRepository proveedorRepository;
	
	public List<Proveedor> listarProveedores() {
		return proveedorRepository.findAll();
	}
	
	public Proveedor buscarProveedorPorId(Long id) {
		return proveedorRepository.findById(id).get();
	}
	
	public Proveedor crearProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}
	
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}
	
	public void eliminarProveedor(Long id) {
		proveedorRepository.deleteById(id);
	}
	
}