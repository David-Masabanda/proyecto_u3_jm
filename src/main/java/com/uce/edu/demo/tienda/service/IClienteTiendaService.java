package com.uce.edu.demo.tienda.service;

import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

public interface IClienteTiendaService {
	
	public ClienteTienda buscarPorCedula(String cedula);
}
