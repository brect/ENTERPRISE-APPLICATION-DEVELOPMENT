package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer>implements MotoristaDAO{

	public MotoristaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
