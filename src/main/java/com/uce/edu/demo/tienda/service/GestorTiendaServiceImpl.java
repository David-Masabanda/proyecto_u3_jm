package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorTiendaServiceImpl implements IGestorTiendaService{


	@Autowired
	private IFacturaTiendaService facturaTiendaService;
	
	
	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String cedula, String numeroFactura, List<String> codigos) {
		
		BigDecimal total=this.facturaTiendaService.generarFactura(cedula, numeroFactura, codigos);
	
		this.facturaElectronicaService.insertarFacturaE(numeroFactura, codigos.size(), total);
	}

}
