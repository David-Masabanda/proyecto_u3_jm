package com.uce.edu.demo.tienda.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente_tienda")
public class ClienteTienda {
	
	@Id
	@Column(name="clie_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="clie_id_seq" )
	@SequenceGenerator(name="clie_id_seq", sequenceName = "clie_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="clie_nombre")
	private String nombre;
	
	@Column(name="clie_apellido")
	private String apellido;
	
	@Column(name="clie_numero_cedula")
	private String numeroCedula;

	@OneToMany(mappedBy="cliente")
	private List<FacturaTienda> facturas;


	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public List<FacturaTienda> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaTienda> facturas) {
		this.facturas = facturas;
	}



	
	
	
	
	
	
}
