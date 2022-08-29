package com.uce.edu.demo.deber.service.funcional;

@FunctionalInterface
public interface IReporteConsumer<T>{
	
	public void accept(T arg1);
}