package br.com.fiap.jpa.teste;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import br.com.fiap.jpa.entity.Funcionario;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		//criar a fabrica de entity manager
		EntityManagerFactory entityManegerFactory = Persistence.createEntityManagerFactory("oracle");
		
		//criar o entity manager
		EntityManager entityManager = entityManegerFactory.createEntityManager();
		
		//pesquisar o funcionario do codigo 1
		Funcionario funcionario = entityManager.find(Funcionario.class, 4);
		
		//exibe os dados do funcionario
		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getDecimoTerceiro());
		
		entityManager.close();
		entityManegerFactory.close();
		
		
	}
	
}
