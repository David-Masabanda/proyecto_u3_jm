package com.uce.edu.demo.deber.service.funcional;

@FunctionalInterface
public interface IPalabraUnaryOperator<T> {

	public T apply(T arg);
}
