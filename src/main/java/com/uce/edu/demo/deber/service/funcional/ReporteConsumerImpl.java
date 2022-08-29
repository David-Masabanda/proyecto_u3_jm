package com.uce.edu.demo.deber.service.funcional;

import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

public class ReporteConsumerImpl implements IReporteConsumer<ClienteTienda>{

	@Override
	public void accept(ClienteTienda c) {
		String tarjeta;
		tarjeta=c.getNombre()+" "+c.getApellido();
		System.out.println("El cliente: "+tarjeta);
		System.out.println("cedula: "+c.getNumeroCedula());
		System.out.println("!!Gana la promocion!!");
	}

}
