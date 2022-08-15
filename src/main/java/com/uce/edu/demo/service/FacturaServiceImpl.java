package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements  IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public Factura consultar(Integer id) {
		return this.facturaRepository.consultar(id);
	}
	
	@Override
	public void create(Factura f) {
		this.facturaRepository.create(f);
	}

	@Override
	public void update(Factura f) {
		this.facturaRepository.update(f);
	}

	@Override
	public void delete(Integer id) {
		this.facturaRepository.delete(id);
	}
	
	//----------------Trab Grupo----------------------------------
	@Override
	public BigDecimal calcularPrecio(Integer id) {
		Factura f=this.facturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		BigDecimal valorFactura=new BigDecimal(0);
		
		for(Detalle p: productos) {
			BigDecimal cantidad=new BigDecimal(p.getCantidad());
			BigDecimal totalProducto=p.getPrecio().multiply(cantidad);
			valorFactura=valorFactura.add(totalProducto);
		}
		
		return valorFactura;
		
	}

	@Override
	public int cantidad(Integer id) {
		Factura f=this.facturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		int canasta=0;
		
		for(Detalle p: productos) {
			canasta=canasta+p.getCantidad();
		}
		
		return canasta;
	}
	//-----------------------------------------------------------

	//INNER JOIN
	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaInnerJoin(precio);
	}

	//OUTER LEFT JOIN
	@Override
	public List<Factura> buscarFacturaOuterJoinLeft( BigDecimal precio) {
		return this.facturaRepository.buscarFacturaOuterJoinLeft(precio);
	}
	
	//OUTER RIGHT JOIN
	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	//WHERE JOIN
	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaJoinWhere(precio);
	}

	//FETCH JOIN
	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio) {
		return this.facturaRepository.buscarFacturaJoinFetch(precio);
	}

}
