package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cargo;
import br.com.fiap.jpa.entity.Funcionario;

public class AtualizaTeste {

	public static void main(String[] args) {
		//Criar a fabrica de entity manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Criar um objeto funcionário com um código existente no bd
		Funcionario func = new Funcionario("Cabral", 
			Cargo.ANALISTA, 10000, Calendar.getInstance(), null);
		
		func.setMatricula(1);
		
		//Atualizar
		em.merge(func);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}