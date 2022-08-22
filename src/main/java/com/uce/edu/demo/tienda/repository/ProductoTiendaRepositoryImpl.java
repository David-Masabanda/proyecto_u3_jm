package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.ProductoTienda;

@Repository
@Transactional
public class ProductoTiendaRepositoryImpl implements IProductoTiendaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public ProductoTienda buscarProducto(String codigo) {
		TypedQuery<ProductoTienda> myQuery=this.entityManager.createQuery(
				"SELECT p FROM ProductoTienda p WHERE p.codigo= :datoCodigo", 
				ProductoTienda.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public int actualizarStock(String codigo) {
		Query myQuery=this.entityManager.createQuery(
				"UPDATE ProductoTienda p SET p.stock=p.stock-1 WHERE p.codigo= :datoCodigo");
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.executeUpdate();
	}
}
