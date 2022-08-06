package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger( ProyectoU3JmApplication.class);
			
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//WHERE
		LOG.info("Relacionamiento Where");
		List<Hotel> listaHotel=this.hotelService.buscarHotelJoinWhere("Familiar");
		for(Hotel item:  listaHotel) {
			LOG.info("Hotel: "+item.getNombre()+item.getDireccion());
		}
		
		
		LOG.info("Inner Join Eager/Lazy");
		List<Hotel> listaHotel2=this.hotelService.buscarHotelInnerJoin("Suite");
		for(Hotel item:  listaHotel2) {
			LOG.info("Hotel 2: "+item.getNombre()+item.getDireccion());
			LOG.info("Hotel habitaciones"+item.getHabitaciones());
		}
		
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHotel3=this.hotelService.buscarHotelJoinFetch("Familiar");
		for(Hotel h: listaHotel3) {
			LOG.info("Hotel 3 Individual: "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Hotel 3 Habitaciones: "+ha);
			}
		}
		
			
		
		
		
		
	}

}
