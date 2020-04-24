package br.com.padawan.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance() {
		
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("padawan");
		}
		System.out.println("BANCO DE DADOS: " + entityManagerFactory);
		return entityManagerFactory;
	}
}
