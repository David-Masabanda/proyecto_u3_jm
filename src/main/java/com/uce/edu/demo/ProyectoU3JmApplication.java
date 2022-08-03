package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger( ProyectoU3JmApplication.class);
			
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LOG.info("Inner Join 1");
		List<Hotel> listaHoteles=this.hotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel item: listaHoteles) {
			LOG.info("Hotel: "+item.getNombre()+" "+item.getDireccion());
		}
		
		LOG.info("Inner Join 2");
		List<Hotel> listaHoteles2=this.hotelService.buscarHotelInnerJoin2();
		for(Hotel item: listaHoteles2) {
			LOG.info("Hotel: "+item.getNombre()+" "+item.getDireccion());
		}
		
		//LEFT
		LOG.info("Left Join 1");
		List<Hotel> listaHotelesL=this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for(Hotel item: listaHotelesL) {
			LOG.info("Hotel: "+item.getNombre()+" "+item.getDireccion());
		}
		
		LOG.info("\n Left Join 2");
		List<Hotel> listaHotelesL2=this.hotelService.buscarHotelOuterJoinLeft2();
		for(Hotel item: listaHotelesL2) {
			LOG.info("Hotel: "+item.getNombre()+" "+item.getDireccion());
		}
		//RIGHT
		LOG.info("Right Join");
		List<Hotel> listaHotelesR=this.hotelService.buscarHotelOuterJoinRight("Familiar");
		for(Hotel item: listaHotelesR) {
			LOG.info("Hotel: "+item.getNombre()+" "+item.getDireccion());
		}
		
		
		
		
		
		
	}

}
