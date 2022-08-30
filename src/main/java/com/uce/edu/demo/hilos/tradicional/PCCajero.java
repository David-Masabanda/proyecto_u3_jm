package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	public void procesar(Cajero c) {
		System.out.println("Procesando cajero: "+ c.getNombre());
		for(String cliente: c.getClientes()) {
			this.atenderCliente(cliente);
		}
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+ cliente);
		//Demora el metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
