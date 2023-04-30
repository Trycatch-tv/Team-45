package com.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el codigo" )
    @Size(min = 5, max = 10,message = "Mínimo 5 numeros y máximo 10")
    @Column
    private String codigo;

    @NotBlank(message = "Debe ingresar el nombre del almacen" )
    @Column
    private String nombre;

   @Column
    private Date   FechaApertura;

    @Column
    private Date FechaCierre;

    @Column
    private Double Total;

    @Column
    private String AlmacenId;

}
