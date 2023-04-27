package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Debe ingresar el documento" )
	@Size(min = 5, max = 15,message = "Mínimo 5 numeros y máximo 15")
	@Column
	private String documento;

	@NotBlank(message = "Debe ingresar en nombre completo" )
	@Column
	private String nombre;

	@NotBlank(message = "Debe ingresar ela direccion" )
	@Column
	private String direccion;

	@NotBlank(message = "Debe ingresar enla ciudad" )
	@Column
	private String ciudad ;

	@NotBlank(message = "El teléfono es obligatorio")
    @Min(value = 5, message = "Cantidad de numeros minimos es 5")
    @Max(value = 10,message = "Maximo de numeros 10")
//    @Pattern(regexp = "^[0-9]{1,2}$", message = "Solo númeeros")
    @Column(name = "phone")
    private int telefono;

}