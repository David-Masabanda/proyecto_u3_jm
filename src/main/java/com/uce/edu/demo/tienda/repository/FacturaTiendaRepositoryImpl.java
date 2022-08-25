package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.FacturaTienda;

@Repository
@Transactional
public class FacturaTiendaRepositoryImpl implements IFacturaTiendaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarFactura(FacturaTienda f) {
		this.entityManager.persist(f);	
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(FacturaTienda f) {
		this.entityManager.merge(f);
		
	}

}
