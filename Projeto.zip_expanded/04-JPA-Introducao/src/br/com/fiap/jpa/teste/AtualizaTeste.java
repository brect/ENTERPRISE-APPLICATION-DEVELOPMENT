package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cargo;
import br.com.fiap.jpa.entity.Funcionario;

public class AtualizaTeste {

	
	public static void main(String[] args) {
		
		//criar fabrica de entity manager
		EntityManagerFactory entityManegerFactory = Persistence.createEntityManagerFactory("oracle");
		
		//criar o entity manager
		EntityManager entityManager = entityManegerFactory.createEntityManager();
		
		//criar um objeto funcionario com um codigo existente no bd
		Funcionario func = new Funcionario(
				"Bruno", 
				Cargo.ESTAGIARIO,
				1500,
				Calendar.getInstance(),
				null);
		func.setMatricula(1);
		
		//atualizar
		entityManager.merge(func);
		
		//commit
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		
		//fecha as paradas
		entityManager.close();
		entityManegerFactory.close();
		
	}
	
}
