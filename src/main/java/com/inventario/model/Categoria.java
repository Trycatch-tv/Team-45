package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el codigo" )
    @Size(min = 5, max = 10,message = "Mínimo 5 numeros y máximo 10")
    @Column(name="codigo_categoria")
    private String codigoCategoria;

    @NotBlank(message = "Debe ingresar el nombre de la categoria" )
	@Column(name="Nombre")
    private String nombreCategoria;

	@Column(name="Descripcion")
    private String descripcionCategoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        return new EqualsBuilder().append(id, categoria.id).append(codigoCategoria, categoria.codigoCategoria)
                .append(nombreCategoria, categoria.nombreCategoria)
                .append(descripcionCategoria, categoria.descripcionCategoria).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(codigoCategoria)
                .append(nombreCategoria).append(descripcionCategoria).toHashCode();
    }
}
