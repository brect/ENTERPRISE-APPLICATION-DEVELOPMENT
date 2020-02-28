package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RemoveTeste {

	public static void main(String[] args) {
		//criar fabrica de entity manager
		EntityManagerFactory entityManegerFactory = Persistence.createEntityManagerFactory("oracle");
		
		//criar o entity manager
		EntityManager entityManager = entityManegerFactory.createEntityManager();
		
		//pesquisar em funcionario
		Funcionario func = entityManager.find(Funcionario.class, 2);
		
		//remover
		entityManager.remove(func);
		
		//commit
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		
		//fecha as paradas
		entityManager.close();
		entityManegerFactory.close();
		
	}
	
}
