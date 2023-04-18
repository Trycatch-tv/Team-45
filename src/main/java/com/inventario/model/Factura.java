package com.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date",length = 20, nullable = false)
	private String fecha;
	@Column(name = "time",length = 10, nullable = false)
	private String hora;
	@Column(name = "comments",length = 100, nullable = false)
	private String comentario;
	public Factura(Long id, String fecha, String hora, String comentario) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.comentario = comentario;
	}
	public Factura() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", comentario=" + comentario + "]";
	}
	
	
}
