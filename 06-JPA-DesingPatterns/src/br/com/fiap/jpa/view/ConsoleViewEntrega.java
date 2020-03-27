package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.impl.GenericDAOImpl;
import br.com.fiap.entity.Entrega;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleViewEntrega {

	
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		GenericDAO<Entrega, Integer> dao = new GenericDAOImpl<Entrega, Integer>(entityManager);

		
		try {
			dao.cadastrar(new Entrega());
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
