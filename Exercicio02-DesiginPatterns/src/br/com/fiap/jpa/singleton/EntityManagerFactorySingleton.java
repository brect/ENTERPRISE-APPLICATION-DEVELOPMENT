package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance() {
		if (entityManagerFactory == null) {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
			
		}
		return entityManagerFactory;
	}
	
}
