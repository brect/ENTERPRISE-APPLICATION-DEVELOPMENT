package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	//atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	//construtor privado -> não é possível instanciar a classe
	private EntityManagerFactorySingleton() {}
	
	//método estático que cria e retorna a única instância
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

}