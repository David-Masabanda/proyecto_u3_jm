package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger( ProyectoU3JmApplication.class);
			
	//@Autowired
	//private IHotelService hotelService;
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// INNER
		LOG.info("INNER JOIN");
		List<Factura> listaFactura = this.facturaService.buscarFacturaInnerJoin(new BigDecimal(6.50));
		for(Factura item:  listaFactura) {
			LOG.info("Hotel: "+item.getDetalles());
		}
		
		
		// LEFT
		LOG.info("LEFT JOIN");
		List<Factura> listaFactura2= this.facturaService.buscarFacturaOuterJoinLeft(new BigDecimal(8.50));
		for(Factura item:  listaFactura2) {
			LOG.info("Hotel: "+item.getDetalles());
		}
			
		
		// RIGHT
		LOG.info("RIGHT JOIN");
		List<Factura> listaFactura3 = this.facturaService.buscarFacturaOuterJoinRight(4);
		for(Factura item:  listaFactura3) {
			LOG.info("Hotel: "+item.getDetalles());
		}
			
		
	}

}
