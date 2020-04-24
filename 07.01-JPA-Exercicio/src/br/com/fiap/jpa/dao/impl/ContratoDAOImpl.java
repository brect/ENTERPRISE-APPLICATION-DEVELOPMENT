package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ContratoDAO;
import br.com.fiap.jpa.entity.Contrato;

public class ContratoDAOImpl 
			extends GenericDAOImpl<Contrato, Integer> implements ContratoDAO {

	public ContratoDAOImpl(EntityManager em) {
		super(em);
	}

}