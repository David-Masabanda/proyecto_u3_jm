package com.uce.edu.demo.deber.service.funcional;

@FunctionalInterface
public interface IVentaPredicate<T> {

	public boolean evaluar(T arg);
}
