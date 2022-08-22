package com.uce.edu.demo.tienda.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura_tienda")
public class FacturaTienda {
		
	@Id
	@Column(name="fact_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="fact_id_seq" )
	@SequenceGenerator(name="fact_id_seq", sequenceName = "fact_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name="fact_numero")
	private String numero;
	
	@Column(name="fact_total")
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="fact_clie_id")
	private ClienteTienda cliente;
	
	@OneToMany(mappedBy="factura")
	private List<DetalleFactura> detalles;

	//Set y Get
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public ClienteTienda getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTienda cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "FacturaTienda [detalles=" + detalles + "]";
	}
	
	
}
