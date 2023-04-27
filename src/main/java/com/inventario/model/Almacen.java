package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el codigo" )
    @Size(min = 5, max = 10,message = "Mínimo 5 numeros y máximo 10")
    @Column(name="codigo")
    private String codigo;

    @NotBlank(message = "Debe ingresar el nombre del almacen" )
	@Column
    private String nombreAlmacen;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10}$", message = "Solo admite numeros ingrese 10 digitos")
	@Column(name="telefono_almacen")
    private String telefonoAlmacen;


	@Column(name="correo")
    private String emailAlmacen;


}
