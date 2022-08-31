package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		Cajero cajero=new Cajero("Edison", Arrays.asList("Pepito", "Juan", "Daniela","David"));
		Cajero cajero1=new Cajero("Sofia", Arrays.asList("Luis", "Andrea", "Marta","Alex"));
		Cajero cajero2=new Cajero("Lucas", Arrays.asList("Pablo", "Jorge", "Daniel","Sara"));
		
		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(cajero);
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("El tiempo transcurrido es: "+tiempoTranscurrido);

	}

}
