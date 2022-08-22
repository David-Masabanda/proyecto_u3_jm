package com.uce.edu.demo.tienda.service;

import java.util.List;

public interface IGestorTiendaService {
	
	public void crearFactura(String cedula, String numeroFactura, List<String> codigos);

}
