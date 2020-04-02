package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.entity.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer>implements PassageiroDAO{

	public PassageiroDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
}
