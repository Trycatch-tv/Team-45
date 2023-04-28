package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.Categoria;
import com.inventario.repository.ICategoriaRepository;

@Service
public class CategoriaService {
	
	private final ICategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaService(ICategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> listarCategorias() {

		return categoriaRepository.findAll();
	}
	
	public Categoria buscarCategoriaPorId(Long id) {

		return categoriaRepository.findById(id).get();
	}
	
	public Categoria crearCategoria(Categoria categoria) {

		return categoriaRepository.save(categoria);
	}
	
	public Categoria actualizarCategoria(Categoria categoria) {

		return categoriaRepository.save(categoria);
	}
	
	public void eliminarCategoria(Long id) {

		categoriaRepository.deleteById(id);
	}
	
}
