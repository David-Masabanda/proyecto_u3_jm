package com.uce.edu.demo.deber.service.funcional;

public class CodigoFunctionImpl implements ICodigoFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg) {
		String codigo = arg + "00xf";
		return codigo;
	}

}
