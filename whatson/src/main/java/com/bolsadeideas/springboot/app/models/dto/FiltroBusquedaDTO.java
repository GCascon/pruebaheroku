package com.bolsadeideas.springboot.app.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bolsadeideas.springboot.app.models.entity.Lugar;

public class FiltroBusquedaDTO {
	@NotEmpty
	private String tipo;
	@NotNull
	private Lugar lugar;
	
	private String posicion;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}
