package com.smartcities.dao;

import javax.persistence.EntityManager;

import com.smartcities.entity.Estabelecimento;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer>{

	public EstabelecimentoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
