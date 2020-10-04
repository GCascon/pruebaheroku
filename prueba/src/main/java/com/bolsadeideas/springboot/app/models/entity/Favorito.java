package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "favoritos")
public class Favorito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String direccion;
	
	@NotEmpty
	private String url;	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Lugar lugar;
	
	
	private String tipo;
		
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	public String getDireccion() {
		return direccion;
	}





	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public String getUrl() {
		return url;
	}





	public void setUrl(String url) {
		this.url = url;
	}





	public Lugar getLugar() {
		return lugar;
	}





	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}







	private static final long serialVersionUID = 1L;

}
