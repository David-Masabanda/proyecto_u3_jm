package com.uce.edu.demo.tienda.repository;

import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

public interface IClienteTiendaRepository {
	
	public ClienteTienda buscarPorCedula(String cedula);
}
