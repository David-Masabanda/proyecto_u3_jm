package com.uce.edu.demo.hilos.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;


public class MainDeberStream {
	
	private static Logger LOG =Logger.getLogger( MainDeberStream.class);

	public static void main(String[] args) {
		
		
		LOG.info("JAVA Supplier");
		Stream<String> streamSupplier=Stream.generate(()->"hola1").limit(7);
		streamSupplier.forEach(cadena -> System.out.println(cadena));		
				
		LOG.info("JAVA Consumer");
		List<String> streamConsumer=Arrays.asList("Inteligencia Artificial","Base de Datos","Investigacion","Fisica","Programacion");
		streamConsumer.forEach(numero -> System.out.println("Materia: "+numero));
		
		LOG.info("JAVA Predicate");
		List<String> listaApellidos=Arrays.asList("Lopez","Apraez","Martinez","Zambrano","Costa");
		Stream<String> streamPredicate=listaApellidos.stream().filter(nombre -> nombre.compareTo("Loza")>0);
		streamPredicate.forEach(dato -> System.out.println("Estudiante: "+dato));
		
		LOG.info("JAVA Function");
		List<String> listaNombres=Arrays.asList("David","Sara","Marcos","Cesar","Sofia");
		Stream<String> streamFunction=listaNombres.stream().map(nombre->{
			String valor=nombre.concat(" Filosofia II");
			return valor;
		});
		streamFunction.forEach(valor->System.out.println("Estudiante: "+valor));


	}

}
