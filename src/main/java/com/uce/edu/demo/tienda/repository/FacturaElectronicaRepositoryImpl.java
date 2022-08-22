package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarFactura(FacturaElectronica f) {
		this.entityManager.persist(f);
		
	}

}
