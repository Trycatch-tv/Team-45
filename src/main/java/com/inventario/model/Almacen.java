package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    public Long getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(Long almacenId) {
        this.almacenId = almacenId;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getTelefonoAlmacen() {
        return telefonoAlmacen;
    }

    public void setTelefonoAlmacen(String telefonoAlmacen) {
        this.telefonoAlmacen = telefonoAlmacen;
    }

    public String getEmailAlmacen() {
        return emailAlmacen;
    }

    public void setEmailAlmacen(String emailAlmacen) {
        this.emailAlmacen = emailAlmacen;
    }

}
