package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.Categoria;
import com.inventario.repository.ICategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private ICategoriaRepository CategoriaRepository;
	
	public List<Categoria> listarCategoriaes() {
		return CategoriaRepository.findAll();
	}
	
	public Categoria buscarCategoriaPorId(Long id) {
		return CategoriaRepository.findById(id).get();
	}
	
	public Categoria crearCategoria(Categoria Categoria) {
		return CategoriaRepository.save(Categoria);
	}
	
	public Categoria actualizarCategoria(Categoria Categoria) {
		return CategoriaRepository.save(Categoria);
	}
	
	public void eliminarCategoria(Long id) {
		CategoriaRepository.deleteById(id);
	}
	
}
