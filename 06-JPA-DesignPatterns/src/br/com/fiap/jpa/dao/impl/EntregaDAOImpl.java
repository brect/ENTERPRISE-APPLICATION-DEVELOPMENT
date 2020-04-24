package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.EntregaDAO;
import br.com.fiap.jpa.entity.Entrega;

public class EntregaDAOImpl extends GenericDAOImpl<Entrega, Integer> implements EntregaDAO {

	public EntregaDAOImpl(EntityManager em) {
		super(em);
	}

}