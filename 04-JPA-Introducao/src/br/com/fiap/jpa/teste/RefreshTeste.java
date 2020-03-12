package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class RefreshTeste {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		//Pesquisar um funcionário
		Funcionario func = em.find(Funcionario.class, 1);
		//Exibir o nome
		System.out.println(func.getNome());
		//Setar o nome 
		func.setNome("Douglas");
		//Exibir o nome
		System.out.println(func.getNome());
		//Fazer refresh
		em.refresh(func);
		//Exibir o nome
		System.out.println(func.getNome());
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}