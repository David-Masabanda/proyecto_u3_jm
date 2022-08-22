package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(DetalleFactura d) {
		this.entityManager.persist(d);
		
	}

}
