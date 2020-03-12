package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Funcionario;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Criar a fabrica de Entity Manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o funcionário de código 1
		Funcionario func = em.find(Funcionario.class, 7);
		//Exibir os dados do funcionário
		System.out.println(func.getNome());
		System.out.println(func.getDecimoTerceiro());
		//Atualizar o objeto no banco
		/*func.setSalario(20000);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		*/
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}