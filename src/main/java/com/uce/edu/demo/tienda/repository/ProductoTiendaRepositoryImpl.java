package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	@Transactional(value = TxType.MANDATORY)
	public ProductoTienda buscarProducto(String codigo) {
		TypedQuery<ProductoTienda> myQuery=this.entityManager.createQuery(
				"SELECT p FROM ProductoTienda p WHERE p.codigo= :datoCodigo", 
				ProductoTienda.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}


	@Override
	public void actualizar(ProductoTienda p) {
		this.entityManager.merge(p);
		
	}
}
