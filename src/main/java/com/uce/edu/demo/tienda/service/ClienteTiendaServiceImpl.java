package com.uce.edu.demo.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tienda.repository.IClienteTiendaRepository;
import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

@Service
public class ClienteTiendaServiceImpl implements IClienteTiendaService{

	@Autowired
	private IClienteTiendaRepository clienteRepository;

	@Override
	public ClienteTienda buscarPorCedula(String cedula) {
		return this.clienteRepository.buscarPorCedula(cedula);
	}
	
	
}
