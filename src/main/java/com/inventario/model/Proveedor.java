package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
@ToString
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

	@NotNull(message = "El teléfono es obligatorio")
    @Min(value = 5, message = "Cantidad de numeros minimos es 5")
    @Max(value = 10,message = "Maximo de numeros 10")
//    @Pattern(regexp = "^[0-9]{1,2}$", message = "Solo númeeros")
    @Column(name = "phone")
    private int telefono;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Proveedor proveedor = (Proveedor) o;

		return new EqualsBuilder().append(telefono, proveedor.telefono).append(id, proveedor.id)
				.append(documento, proveedor.documento).append(nombre, proveedor.nombre)
				.append(direccion, proveedor.direccion).append(ciudad, proveedor.ciudad).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(documento)
				.append(nombre).append(direccion).append(ciudad).append(telefono).toHashCode();
	}
}
