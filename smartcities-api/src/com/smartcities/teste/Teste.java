package com.smartcities.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.smartcities.dao.ClienteDAO;
import com.smartcities.entity.Cliente;

public class Teste {

	
	public static void main(String[] args) {
		
		EntityManager entityManager = Persistence
										.createEntityManagerFactory("smartcities")
										.createEntityManager();
		
		ClienteDAO clienteDao = new ClienteDAO(entityManager);
		
		Cliente cliente = new Cliente(0, "Bruno");
		clienteDao.cadastrar(cliente);
		
		
		try {
			clienteDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
