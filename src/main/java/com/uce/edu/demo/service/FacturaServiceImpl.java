package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements  IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public Factura consultar(Integer id) {
		return this.facturaRepository.consultar(id);
	}

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
