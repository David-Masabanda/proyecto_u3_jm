package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;


@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Factura consultar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	//INNER JOIN
	@Override
	public List<Factura> buscarFacturaInnerJoin(LocalDateTime fechaCompra) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Fact f INNER JOIN f.detalles d WHERE f.fecha= : datoFecha ", 
				Factura.class);
		myQuery.setParameter("datoFecha", fechaCompra);
		return myQuery.getResultList();
	}

	
	//OUTER JOIN LEFT
	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Fact f LEFT JOIN f.detalles d WHERE d.subtotal= : datoPrecio ", 
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}


	//OUTER JOIN RIGHT
	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Fact f RIGHT JOIN f.detalles d WHERE d.cantidad>= : datoCantidad ", 
				Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}



}
