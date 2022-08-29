package com.uce.edu.demo.deber.service.funcional;

import java.math.BigDecimal;
import java.util.Random;

import org.jboss.logging.Logger;

import com.uce.edu.demo.service.funcional.IPersonaConsumer;
import com.uce.edu.demo.service.funcional.IPersonaFunction;
import com.uce.edu.demo.service.funcional.IPersonaPredicate;
import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

public class MainDeberInterfacesFuncionales {
	
	private static Logger LOG =Logger.getLogger( MainDeberInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		
		MetodosHO metodos= new MetodosHO();
		
		//SUPLIER
			//*Clase
		IDatosSupplier<BigDecimal>supplier=new DatosSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getDato());
			//*Lambda
		IDatosSupplier<BigDecimal>supplierLambda=()->{
			Integer numero=new Random().nextInt(30);
			BigDecimal valor= new BigDecimal(numero);
			BigDecimal iva=valor.multiply(new BigDecimal(0.17));
			return iva;
		};
		LOG.info("Supplier Lambda: "+supplierLambda.getDato());
			//*High Order
		BigDecimal valorHO=metodos.consumirSupplier(()->{
			Integer numero=new Random().nextInt(5);
			BigDecimal valor= new BigDecimal(numero);
			BigDecimal iva=valor.multiply(new BigDecimal(0.25));
			return iva;
		});
		LOG.info("Supplier High Order: "+ valorHO);
				

		
		//CONSUMER
		ClienteTienda c=new ClienteTienda();
		c.setNombre("David");
		c.setApellido("Lopez");
		c.setNumeroCedula("102030");
			//*Clase
		IReporteConsumer<ClienteTienda>consumer=new ReporteConsumerImpl();
		consumer.accept(c);
			//*Lambda
		IPersonaConsumer<ClienteTienda>consumerLambda= cadena-> {
			String tarjeta;
			tarjeta=cadena.getNombre()+" "+cadena.getNumeroCedula();
			System.out.println("El cliente: "+tarjeta);
			System.out.println("!!Perdio la oferta!!");
		};
		consumerLambda.accept(c);
			//*High Order
		metodos.consumirConsumer(valor ->{
			String tarjeta;
			tarjeta=valor.getApellido();
			System.out.println("El cliente: "+tarjeta);
			System.out.println("!!La oferta expiro!!");
		}, c);
		
		
		
		//PREDICATE
			//*Clase
		IVentaPredicate<String>predicate=new VentaPredicateImpl();
		LOG.info("Predicate Clase: "+"Ganararon la oferta: "+predicate.evaluar("Supermaxi"));
			//*Lambda
		IPersonaPredicate<String> predicateLambda= cadena->	cadena.contains("x");
		LOG.info("Predicate Lambda: "+predicateLambda.evaluar("Santa Maria"));
			//*High Order
		boolean respuesta=metodos.consumirPredicate(cadena->{
			if (cadena.equals("tienda")){
				return true;
			}else {
				return false;
			}
		}, "zapato");
		LOG.info("Predicate High Order: "+ respuesta);
		
		
		
		//FUNCTION
			//*Clase
		ICodigoFunction<String , Integer>funcion=new CodigoFunctionImpl();
		LOG.info("Function Clase: "+funcion.aplicar(23));
			//*Lambdas
		IPersonaFunction<String, Integer> functionLambda= cadena ->{
			String codigo = cadena + "00";
			return codigo;
			};
		LOG.info("Function Clase: "+functionLambda.aplicar(2));
			//*High Order
		String valorFinal=metodos.consumirFunction(valor->{
			String retorno=valor.toString()+"121879";
			return retorno;
		}, 4);
		LOG.info("Function High Order: "+ valorFinal);
		
		
		
		//UNARY OPERATOR 
			//*Clase
		IPalabraUnaryOperator<String>unaryOperator=new PalabraUnaryOperatorImpl();
		LOG.info("UnaryOperator Clase: "+unaryOperator.apply("David"));
			//*Lambda
		IPalabraUnaryOperator<String> unaryLambda=cadena->{
			String valroFinal=cadena.concat("12151800");
			valroFinal=valroFinal.replace('a', 'o');
			return valroFinal;
		};
		LOG.info("UnaryOperator Lambda: "+unaryLambda.apply("Manzana"));
			//*High Order
		String valorFinal2=metodos.consumirUnary(valor->{
			String palabra="Programacion avanzada ";
			palabra=palabra.concat(valor);
			return palabra;
		}, "David");
		LOG.info("Unary High Order: "+ valorFinal2);
		
		
	
		
	}
}
