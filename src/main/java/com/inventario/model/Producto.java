package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre" )
	@Column
    private String nombre;

	@Column
    private String descripcion;

    @NotEmpty(message = "Debe ingresar el precio de venta" )
	@Column
    private int precioventa;

    @NotEmpty(message = "Debe ingresar el precio de costo" )
    @Column
    private int preciocosto;



    @Column
    private boolean disponible;

}
