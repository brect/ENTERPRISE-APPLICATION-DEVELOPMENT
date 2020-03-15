package com.smartcities.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.smartcities.dao.ClienteDAO;
import com.smartcities.entity.Cliente;

public class ClienteServiceImpl implements ClienteService{

	@Override
	public Cliente buscar(int id) throws RemoteException {
		EntityManager entityManager = Persistence
										.createEntityManagerFactory("smartcities")
										.createEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		return clienteDAO.buscar(id);
	}

	
}
