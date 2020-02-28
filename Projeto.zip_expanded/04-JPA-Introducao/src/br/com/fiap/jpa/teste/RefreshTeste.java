package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RefreshTeste {
	
	public static void main(String[] args) {
		//criar fabrica de entity manager
		EntityManagerFactory entityManegerFactory = Persistence.createEntityManagerFactory("oracle");
		
		//criar o entity manager
		EntityManager entityManager = entityManegerFactory.createEntityManager();
		
		
		//pesquisar em funcionario
		Funcionario func = entityManager.find(Funcionario.class, 1);
		
		//exibir o nome
		System.out.println(func.getNome());
		
		//setar o nome
		func.setNome("Xurupita");
		
		//exibir o nome
		System.out.println(func.getNome());
		
		//fazer o refresh
		entityManager.refresh(func);
		
		//exibir o nome
		System.out.println(func.getNome());
		
		//fecha as paradas
		entityManager.close();
		entityManegerFactory.close();
		
	
	}

}
