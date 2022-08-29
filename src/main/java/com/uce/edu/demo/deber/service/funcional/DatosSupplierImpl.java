package com.uce.edu.demo.deber.service.funcional;

import java.math.BigDecimal;
import java.util.Random;

public class DatosSupplierImpl implements IDatosSupplier<BigDecimal>{

	@Override
	public BigDecimal getDato() {
		//Calcular el iva de un numero randomico
		Integer numero=new Random().nextInt(20);
		BigDecimal valor= new BigDecimal(numero);
		BigDecimal iva=valor.multiply(new BigDecimal(0.12));
		return iva;
	}

}
