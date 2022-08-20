package com.uce.edu.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
	
	private static Logger LOG =Logger.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin2() {
		return this.hotelRepository.buscarHotelInnerJoin2();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft2() {
		return this.hotelRepository.buscarHotelOuterJoinLeft2();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		LOG.info("Transaccion activa service: "+TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

	
	//Trabajo Grupal
	@Override
	public void insertar(Hotel h) {
		this.hotelRepository.insertar(h);
		
	}

	@Override
	public Hotel buscarHotel(String tipo) {
		return this.hotelRepository.buscarHotel(tipo);
	}

	@Override
	public Hotel buscar(Integer id) {
		return this.hotelRepository.buscar(id);
	}

	@Override
	public ContadorHabitaciones contarHabitaciones(Integer id, String tipo) {
		return this.hotelRepository.contarHabitaciones(id, tipo);
	}
 




}
