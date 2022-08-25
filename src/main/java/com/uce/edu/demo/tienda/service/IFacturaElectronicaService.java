package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {

	public void insertarFacturaE(String numeroFactura, Integer items, BigDecimal total);
}
