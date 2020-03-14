package com.smartcities.dao;

import javax.persistence.EntityManager;

import com.smartcities.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer>{

	public ClienteDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
