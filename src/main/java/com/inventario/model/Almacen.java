package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long almacenId;
	@Column(name="Nombre")
    private String nombreAlmacen;
	@Column(name="Telefono")
    private String telefonoAlmacen;
	@Column(name="Correo")
    private String emailAlmacen;


}
