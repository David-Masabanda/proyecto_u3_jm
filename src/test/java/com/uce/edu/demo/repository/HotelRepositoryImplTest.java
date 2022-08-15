package com.uce.edu.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
class HotelRepositoryImplTest {

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Test
	void testBuscarHotel() {
		Hotel h=new Hotel();
		//h.setId(6);
		h.setDireccion("Barcelona");
		//Barcelona prueba correcta
		//Francia prueba fallida

		assertEquals(h.getDireccion(), this.hotelRepository.buscarHotel("Suite").getDireccion());
	}

}
