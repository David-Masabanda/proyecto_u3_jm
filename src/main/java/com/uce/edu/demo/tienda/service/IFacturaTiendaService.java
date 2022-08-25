package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaTiendaService {

	public BigDecimal generarFactura(String cedula, String numeroFactura, List<String> codigos);
}
