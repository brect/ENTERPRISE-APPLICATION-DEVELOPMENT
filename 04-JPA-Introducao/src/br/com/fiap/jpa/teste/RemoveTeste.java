package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RemoveTeste {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		//Pesquisar o funcionário
		Funcionario func = em.find(Funcionario.class, 5);
		//Remover
		em.remove(func);
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(func.getNome());
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}