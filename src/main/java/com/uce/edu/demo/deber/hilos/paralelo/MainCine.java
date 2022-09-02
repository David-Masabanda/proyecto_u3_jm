package com.uce.edu.demo.deber.hilos.paralelo;

import java.util.Arrays;

public class MainCine {

	public static void main(String[] args) {
		
		long tiempoInicial=System.currentTimeMillis();
		
		SalaCine sala1=new SalaCine("A1", Arrays.asList("El conjuro", "Ant man", "Buenos chicos") , 80, "Raul");
		SalaCine sala2=new SalaCine("A2", Arrays.asList("La Bruja de Blair", "Coco") , 50, "Samanta");
		SalaCine sala3=new SalaCine("A3", Arrays.asList("Stranger Things", "Better Call Saul", "Game of Thrones", "The Mandalorian") , 70, "Steve");
		SalaCine sala4=new SalaCine("A4", Arrays.asList("End Game") , 35, "Alex");
		SalaCine sala5=new SalaCine("A5", Arrays.asList("Joker", "The Batman") , 40, "Sebastian");
		
		
		
		SalaProyeccion proyeccion1=new SalaProyeccion(sala1);
		proyeccion1.start();
		
		SalaProyeccion proyeccion2=new SalaProyeccion(sala2);
		proyeccion2.start();
		
		SalaProyeccion proyeccion3=new SalaProyeccion(sala3);
		proyeccion3.start();
		
		SalaProyeccion proyeccion4=new SalaProyeccion(sala4);
		proyeccion4.start();
		
		SalaProyeccion proyeccion5=new SalaProyeccion(sala5);
		proyeccion5.start();
		
		
		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("El tiempo transcurrido es: "+tiempoTranscurrido);
		

	}

}
