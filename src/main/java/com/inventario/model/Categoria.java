package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el codigo" )
    @Size(min = 5, max = 10,message = "Mínimo 5 numeros y máximo 10")
    @Column
    private String codigo;

    @NotBlank(message = "Debe ingresar el nombre de la categoria" )
	@Column
    private String nombre;

	@Column
    private String descripcion;

}
