package com.uce.edu.demo.tienda.repository;

import com.uce.edu.demo.tienda.repository.modelo.FacturaTienda;

public interface IFacturaTiendaRepository {
	
	public void insertarFactura(FacturaTienda f);
	public void actualizar(FacturaTienda f);
}
