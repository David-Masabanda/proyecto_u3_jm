package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		
		CajeroParalelo cajero1 = new CajeroParalelo("Juan", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Luis", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3"));
		
		
		CajeroParalelo cajero4 = new CajeroParalelo("Juan", Arrays.asList( "Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Luis", Arrays.asList( "Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList( "Juan3"));
		
		
		
		PCCajeroParalelo gestorAtencion=new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); //PROCESAR
		PCCajeroParalelo gestorAtencion1=new PCCajeroParalelo(cajero2);
		gestorAtencion1.start();  //PROCESAR
		PCCajeroParalelo gestorAtencion2=new PCCajeroParalelo(cajero3);
		gestorAtencion2.start();  //PROCESAR
		
		PCCajeroParalelo gestorAtencion3=new PCCajeroParalelo(cajero4);
		gestorAtencion3.start(); //PROCESAR
		PCCajeroParalelo gestorAtencion4=new PCCajeroParalelo(cajero5);
		gestorAtencion4.start();  //PROCESAR
		PCCajeroParalelo gestorAtencion5=new PCCajeroParalelo(cajero6);
		gestorAtencion5.start();  //PROCESAR
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("El tiempo transcurrido es: "+tiempoTranscurrido);


	}

}
