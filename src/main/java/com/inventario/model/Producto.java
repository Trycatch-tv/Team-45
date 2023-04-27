package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre" )
	@Column(name="Nombre")
    private String nombre;

	@Column
    private String descripcion;

    @NotEmpty(message = "Debe ingresar el precio de venta" )
	@Column(name="precio_venta")
    private int precioVenta;

    @NotEmpty(message = "Debe ingresar el precio de costo" )
    @Column(name="precio_costo")
    private int precioCosto;



    @Column
    private boolean disponible;

}
