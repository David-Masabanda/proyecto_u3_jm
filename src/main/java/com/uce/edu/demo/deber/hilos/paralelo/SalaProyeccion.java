package com.uce.edu.demo.deber.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class SalaProyeccion extends Thread{
	
	private SalaCine sala;

	public SalaProyeccion(SalaCine sala) {
		this.sala = sala;
	}
	
	@Override
	public void run() {
		this.proyeccion(this.sala);
	}
	
	public void proyeccion(SalaCine sala) {
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre hilo proyectar: "+ Thread.currentThread().getName());
		System.out.println("Preparando sala: "+ sala.getSala());
		for(String pelicula : sala.getPelicula()) {
			this.proyectarPelicula(pelicula);
		}
		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println("La funcion en la sala: "+sala.getSala()+" termino en "+tiempoTranscurrido+" seg");
	}
		
	public void proyectarPelicula(String pelicula) {
		System.out.println("Proyectando pelicula: "+ pelicula);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
