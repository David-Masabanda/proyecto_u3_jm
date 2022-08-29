package com.uce.edu.demo.deber.service.funcional;

@FunctionalInterface
public interface ICodigoFunction<R,T> {

	R aplicar(T arg);
}
