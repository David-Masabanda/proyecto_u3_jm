package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;
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
@Table(name="fact")
public class Factura {
	
	@Id
	@Column(name="fac_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="fac_id_seq" )
	@SequenceGenerator(name="fac_id_seq", sequenceName = "fac_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="fac_fecha")
	private LocalDateTime fecha;
	
	@Column(name="fac_numero")
	private String numero;

	//, fetch=FetchType.EAGER
	@OneToMany(mappedBy="factura")
	private List<Detalle> detalles;

	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", detalles=" + detalles + "]";
	}
	
	
	
	
}
