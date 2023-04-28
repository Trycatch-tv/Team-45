package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "almacen")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Almacen almacen = (Almacen) o;

        return new EqualsBuilder().append(id, almacen.id).append(codigo, almacen.codigo)
                .append(nombreAlmacen, almacen.nombreAlmacen).append(telefonoAlmacen, almacen.telefonoAlmacen)
                .append(emailAlmacen, almacen.emailAlmacen).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(codigo)
                .append(nombreAlmacen).append(telefonoAlmacen).append(emailAlmacen).toHashCode();
    }
}
