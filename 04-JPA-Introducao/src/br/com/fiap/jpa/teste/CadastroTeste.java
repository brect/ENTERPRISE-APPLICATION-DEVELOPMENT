package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cargo;
import br.com.fiap.jpa.entity.Funcionario;

public class CadastroTeste {

	public static void main(String[] args) {
		//cria a fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		//cria o gerenciador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um funcionário
		Funcionario func = new Funcionario("Juninho", 
				Cargo.COORDENADOR, 10000, 
				Calendar.getInstance(), null);
		
		//Cadastrar no banco de dados
		em.persist(func);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();

		//fecha as paradas
		em.close();
		fabrica.close();
	}
	
}