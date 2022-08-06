package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {
	
	public Factura consultar(Integer id);
	
	//Inner Join
	public List<Factura> buscarFacturaInnerJoin(LocalDateTime fechaCompra);
	//Inner Outer Join Left
	public List<Factura> buscarFacturaOuterJoinLeft( BigDecimal precio);
	//Inner Outer Join Right
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
}
