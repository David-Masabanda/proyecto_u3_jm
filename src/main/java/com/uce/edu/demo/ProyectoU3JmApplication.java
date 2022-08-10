package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger( ProyectoU3JmApplication.class);
			
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		LOG.info("JOIN FETCH");
		List<Hotel> listaHotel3=this.hotelService.buscarHotelJoinFetch("Familiar");
		for(Hotel h: listaHotel3) {
			LOG.info("Hotel 3 Individual: "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Hotel 3 Habitaciones: "+ha);
			}
		}*/
		
		this.transferenciaService.realizarTransferenciaFachada("1213140", "1213150", new BigDecimal(10));
			
			
		
	}

}
