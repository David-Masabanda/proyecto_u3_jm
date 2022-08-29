package com.uce.edu.demo.deber.service.funcional;

public class VentaPredicateImpl implements IVentaPredicate<String>{

	@Override
	public boolean evaluar(String venta) {
		boolean compra;
		if (venta.equals("Supermaxi")){
			//"descuento";
			compra=true;
		}else {
			//"tarifa adicional";
			compra=false;
		}
		return compra;
	}

}
