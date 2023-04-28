package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "producto")
@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        return new EqualsBuilder().append(precioVenta, producto.precioVenta).append(precioCosto, producto.precioCosto)
                .append(disponible, producto.disponible).append(id, producto.id).append(nombre, producto.nombre)
                .append(descripcion, producto.descripcion).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(nombre).append(descripcion)
                .append(precioVenta).append(precioCosto).append(disponible).toHashCode();
    }
}
