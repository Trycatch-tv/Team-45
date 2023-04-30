package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Producto {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre" )
	@Column
    private String nombre;

	@Column
    private String descripcion;

    @NotBlank(message = "El precio de venta es obligatorio")
    @Pattern(regexp = "^[0-9]{1,10}$", message = "Son acepta numeros")
	@Column
    private String precioventa;

    @NotBlank(message = "El precio de costo es obligatorio")
    @Pattern(regexp = "^[0-9]{1,10}$", message = "Son acepta numeros")
    @Column
    private String preciocosto;

    @Column
    private boolean disponible;

}
