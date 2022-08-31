package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread{

	private CajeroParalelo cajero;
	
	public PCCajeroParalelo(CajeroParalelo c) {
		this.cajero=c;
	}
	
	//Dispara el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}
	
	public void procesar(CajeroParalelo c) {
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre hilo procesar: "+Thread.currentThread().getName());
		System.out.println("Procesando cajero: "+ c.getNombre());
		for(String cliente: c.getClientes()) {
			this.atenderCliente(cliente);
		}
		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println("Termino: "+c.getNombre()+" en "+tiempoTranscurrido+" seg");
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+ cliente);
		//Demora el metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
