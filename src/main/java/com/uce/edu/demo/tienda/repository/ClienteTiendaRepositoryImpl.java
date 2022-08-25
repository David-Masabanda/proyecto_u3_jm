package com.uce.edu.demo.tienda.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;

@Repository
@Transactional
public class ClienteTiendaRepositoryImpl implements IClienteTiendaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public ClienteTienda buscarPorCedula(String cedula) {
		TypedQuery<ClienteTienda> myQuery=this.entityManager.createQuery(
				"SELECT c FROM ClienteTienda c WHERE c.numeroCedula= :datoCedula",
				ClienteTienda.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
