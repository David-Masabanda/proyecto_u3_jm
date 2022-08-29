package com.uce.edu.demo.deber.service.funcional;

@FunctionalInterface
public interface IDatosSupplier<T> {

	public T getDato();
}
