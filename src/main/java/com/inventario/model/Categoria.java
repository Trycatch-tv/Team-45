package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    @Column(name="Codigo")
    private String codigoCategoria;
	@Column(name="Nombre")
    private String nombreCategoria;
	
	@Column(name="Descripcion")
    private String descripcionCategoria;

}
