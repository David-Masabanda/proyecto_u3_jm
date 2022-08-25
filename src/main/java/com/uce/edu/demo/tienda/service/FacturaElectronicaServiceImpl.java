package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tienda.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.tienda.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertarFacturaE(String numeroFactura, Integer items, BigDecimal total) {
		
		FacturaElectronica facturaElectronica=new FacturaElectronica();
		facturaElectronica.setFecha(LocalDateTime.now());
		facturaElectronica.setMonto(total);
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setNumeroDetalles(items);
		
		this.facturaElectronicaRepository.insertarFactura(facturaElectronica);
		throw new RuntimeException();
	}

}
