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
		
		
		// WHERE
		LOG.info("WHERE JOIN");
		List<Factura> listaFactura = this.facturaService.buscarFacturaJoinWhere(new BigDecimal(6.50));
		for(Factura item:  listaFactura) {
			LOG.info("Factura: "+item.getNumero()+" "+item.getFecha() );
		}
		
		
		// FETCH
		LOG.info("FETCH JOIN");
		List<Factura> listaFactura2= this.facturaService.buscarFacturaJoinFetch(new BigDecimal(8.50));
		for(Factura item:  listaFactura2) {
			LOG.info("Factura: "+item.getNumero()+" "+item.getFecha() );
		}
			
			
		
	}

}
