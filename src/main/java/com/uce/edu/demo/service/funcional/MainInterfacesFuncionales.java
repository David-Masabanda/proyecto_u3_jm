package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {
	
	private static Logger LOG =Logger.getLogger( MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		
		ConsumoMerodosHighOrder metodosHO=new ConsumoMerodosHighOrder();
		
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
		
		//-------------------------------------------------
		//Metodos High Order
		String valorHO=metodosHO.consumirSupplier(()->"Hola mundo");
		LOG.info("High Order Supplier: "+ valorHO);
		
		String valorHO1=metodosHO.consumirSupplier(()->{
			String valorConsultado="1719130000";
			return valorConsultado;
		});
		LOG.info("HO Supplier 1: "+ valorHO1);
		
		
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 3);
		
		boolean respuesta=metodosHO.consumirPredicate(cadena->cadena.contains("z"), "zapato");
		LOG.info("HO Predicate: "+ respuesta);
		
		String valorFinal=metodosHO.consumirFunction(valor->{
			String retorno=valor.toString()+"A";
			return retorno;
		}, 4);
		LOG.info("HO Function: "+ valorFinal);
	}
}
