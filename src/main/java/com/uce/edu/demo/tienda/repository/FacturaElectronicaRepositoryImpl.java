package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarFactura(FacturaElectronica f) {
		this.entityManager.persist(f);
		
	}

}
