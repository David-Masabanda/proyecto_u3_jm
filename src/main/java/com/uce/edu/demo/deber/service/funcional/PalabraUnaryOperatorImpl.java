package com.uce.edu.demo.deber.service.funcional;

public class PalabraUnaryOperatorImpl implements IPalabraUnaryOperator<String>{

	@Override
	public String apply(String arg) {
		String palabra="Hola mundo ";
		palabra=palabra +arg;
		palabra=palabra.replace("o", "1");
		return palabra;
	}

}
