package com.uce.edu.demo.deber.service.funcional;

import java.math.BigDecimal;

import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

public class MetodosHO {

	public BigDecimal consumirSupplier(IDatosSupplier<BigDecimal> funcion) {
		return funcion.getDato();
	}
	
	public void consumirConsumer(IReporteConsumer<ClienteTienda> funcion, ClienteTienda c) {
		funcion.accept(c);
	}
	
	public boolean consumirPredicate(IVentaPredicate<String>funcion, String valor) {
		return funcion.evaluar(valor);
	}

	
	public String consumirFunction(ICodigoFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}
	
	public String consumirUnary(IPalabraUnaryOperator<String> funcion, String valor) {
		return funcion.apply(valor);
	}
}
