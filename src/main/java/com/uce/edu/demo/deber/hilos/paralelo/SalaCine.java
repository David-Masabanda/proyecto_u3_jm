package com.uce.edu.demo.deber.hilos.paralelo;

import java.util.List;

public class SalaCine {
	
	private String sala;
	private List<String> pelicula;
	private Integer capacidad;
	private String encargado;
	
	
	public SalaCine(String sala, List<String> pelicula, Integer capacidad, String encargado) {
		this.sala = sala;
		this.pelicula = pelicula;
		this.capacidad = capacidad;
		this.encargado = encargado;
	}
	
	
	//SET y GET
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}

	public List<String> getPelicula() {
		return pelicula;
	}

	public void setPelicula(List<String> pelicula) {
		this.pelicula = pelicula;
	}

	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	
	

}
