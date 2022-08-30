package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {
	
	private static Logger LOG =Logger.getLogger( MainInterfacesFuncionales.class);
	public static boolean prueba() {
		return true;
	}
	public static void imprimir(String cadena) {
		LOG.info("Impresion: "+ cadena);
	}
	public static void guardar(String elemento) {
		//LOG.
	}
	public static void main(String[] args) {
		
		
		ConsumoMerodosHighOrder metodosHO=new ConsumoMerodosHighOrder();
		/*
		//SUPLIER
		//*Clases
		IPersonaSupplier<String>supplier=new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		//*Lambdas
		IPersonaSupplier<String>supplierLambda=()->"Martin";
		LOG.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		//CONSUMER
		//*Clases
		IPersonaConsumer<String>consumer=new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		//*Lambdas
		IPersonaConsumer<String>consumerLambda= cadena-> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//PREDICATE
		//*Clases
		//*Lambdas
		IPersonaPredicate<String> predicateLambda= cadena->cadena.contains("z");
		LOG.info("Supplier Predicate: "+predicateLambda.evaluar("zapato"));
		
		//FUNCTION
		//*Clases
		//*Lambdas
		IPersonaFunction<Integer, String> functionLambda= cadena ->{
			Integer valor=Integer.parseInt(cadena);
			Integer valorFinal=valor-2;
			return valorFinal;
			};
		LOG.info("Supplier Function: "+functionLambda.aplicar("7"));
		
		//UNARY OPERATOR (FUNCTION)
		//*Clases
		//*Lambdas
		IPersonaUnaryOperator<String> unaryLambda=cadena->{
			String valroFinal=cadena.concat(" Martinez");
			return valroFinal;
		};
		LOG.info("Supplier Function: "+unaryLambda.apply("David"));
		*/
		
		
		//-------------------------------------------------
		//Metodos High Order
		//SUPPLIER
		String valorHO=metodosHO.consumirSupplier(()->"Hola mundo");
		LOG.info("High Order Supplier: "+ valorHO);
		
		String valorHO1=metodosHO.consumirSupplier(()->{
			String valorConsultado="1719130000";
			return valorConsultado;
		});
		LOG.info("HO Supplier 1: "+ valorHO1);
		//JAVA
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(()->"David").limit(7);
		test.forEach(cadena -> System.out.println(cadena));
		
		//----------------
		//CONSUMER
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 3);
		//JAVA
		LOG.info("Java Consumer");
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero -> System.out.println(numero));
		
		//---------------
		//PREDICATE
		boolean respuesta=metodosHO.consumirPredicate(cadena->cadena.contains("z"), "zapato");
		LOG.info("HO Predicate: "+ respuesta);
		//JAVA
		LOG.info("Java Predicate");
		Stream<Integer>nuevaLista=listaNumeros.stream().filter(numero -> numero>=3 );
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		//------------------------
		//FUNCTION	
		String valorFinal=metodosHO.consumirFunction(valor->{
			String retorno=valor.toString()+"A";
			return retorno;
		}, 4);
		LOG.info("HO Function: "+ valorFinal);
		//JAVA
		LOG.info("Java Function");
		//Conversiones / cast Empleado -> EmpleadoDTO(Ligero)
		Stream<String>listaCambiada=listaNumeros.stream().map(numeroLista->{
			Integer valor=numeroLista+1;
			String cadena ="num: "+valor.toString();
			return cadena;
		});
		listaCambiada.forEach(valor->imprimir(valor));
	}
}
