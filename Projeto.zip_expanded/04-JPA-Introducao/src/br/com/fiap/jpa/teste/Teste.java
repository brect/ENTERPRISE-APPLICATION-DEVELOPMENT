package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//cria a fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		//cria o gerenciador de entidades
		EntityManager em = fabrica.createEntityManager();

		//fecha as paradas
		em.close();
		fabrica.close();
	}
	
}