package com.inventario.service;


import com.inventario.model.Producto;

import com.inventario.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	public List<Producto> listarProducto() {

		return productoRepository.findAll();
	}
	
	public Producto buscarProductoPorId(Long id) {

		return productoRepository.findById(id).get();
	}
	
	public Producto crearProducto(Producto producto) {

		return productoRepository.save(producto);
	}
	
	public Producto actualizarProducto(Producto producto) {

		return productoRepository.save(producto);
	}
	
	public void eliminarProducto(Long id) {

		productoRepository.deleteById(id);
	}
	
}
