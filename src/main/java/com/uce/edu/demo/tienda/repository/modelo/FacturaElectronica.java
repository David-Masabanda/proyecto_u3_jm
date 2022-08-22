package com.uce.edu.demo.tienda.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura_electronica")
public class FacturaElectronica {
	
	@Id
	@Column(name="face_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="face_id_seq" )
	@SequenceGenerator(name="face_id_seq", sequenceName = "face_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="face_numero")
	private String numero;
	
	@Column(name="face_fecha")
	private LocalDateTime fecha;
	
	@Column(name="face_monto")
	private BigDecimal monto;
	
	@Column(name="face_numero_detalles")
	private Integer numeroDetalles;

	
	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroDetalles() {
		return numeroDetalles;
	}

	public void setNumeroDetalles(Integer numeroDetalles) {
		this.numeroDetalles = numeroDetalles;
	}
	
	
}
