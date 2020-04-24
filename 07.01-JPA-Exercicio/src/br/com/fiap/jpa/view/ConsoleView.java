package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ContratoDAO;
import br.com.fiap.jpa.dao.impl.ContratoDAOImpl;
import br.com.fiap.jpa.entity.Aula;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Contrato;
import br.com.fiap.jpa.entity.Dependente;
import br.com.fiap.jpa.entity.Plano;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {
	
	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o Plano
		Plano plano = new Plano("Basico", 59);
		
		//Instanciar um Dependente
		Dependente dependente = new Dependente("Mario");
		
		//Instanciar duas Aulas e adicionar em uma lista
		List<Aula> aulas = new ArrayList<Aula>();
		aulas.add(new Aula("Alongamento", Calendar.getInstance()));
		aulas.add(new Aula("Ginástica", Calendar.getInstance()));
		
		//Instanciar um Cliente com a lista de aulas
		Cliente cliente = new Cliente("Juliana", "(11)98374938", aulas);
		
		//Instanciar um Contrato com o plano, cliente e dependente
		Contrato contrato = new Contrato(Calendar.getInstance(), 600, dependente, plano, cliente);
		
		//Setar o contrato no dependente
		dependente.setContrato(contrato); //Para cadastrar a FK no banco
		
		//Instanciar o DAO do contrato
		ContratoDAO dao = new ContratoDAOImpl(em);
		
		try {
			//Cadastrar o contrato
			dao.cadastrar(contrato);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		em.close();
		fabrica.close();
		
	}
	
}
