package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tienda.service.IGestorTiendaService;

@SpringBootApplication
public class ProyectoU3JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger( ProyectoU3JmApplication.class);
	
	@Autowired
	private IGestorTiendaService gestorTiendaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//this.transferenciasService.realizarTransferenciaFachada("1213140", "1213150", new BigDecimal(1));
		
		List<String>codigos= new ArrayList<String>();
		codigos.add("A0012");
		codigos.add("A0010");
		codigos.add("A0015");
		
		this.gestorTiendaService.crearFactura("1719139002", "1025", codigos);

	}

}
