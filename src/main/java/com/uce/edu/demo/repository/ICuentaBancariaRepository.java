package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	
	public void actualizar(CuentaBancaria cb);
	
	public CuentaBancaria buscarPorNumero(String numero);
}