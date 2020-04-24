package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.ClienteDAO;
import br.com.fiap.jpa.dao.impl.ClienteDAOImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Combustivel;
import br.com.fiap.jpa.entity.Contrato;
import br.com.fiap.jpa.entity.Locacao;
import br.com.fiap.jpa.entity.TipoLocacao;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;

public class ConsoleView {

	public static void main(String[] args) {
		
		//Instanciar uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO do cliente
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		//Instanciar uma locação
		Locacao locacao = new Locacao(350, TipoLocacao.SEMANAL);
		
		//Instanciar um contrato com a locação
		Contrato contrato = new Contrato(Calendar.getInstance(), 
				new GregorianCalendar(2020, Calendar.JULY, 1), locacao);
		
		Cliente cliente = new Cliente("Allen", "allen@fiap.com.br");
		
		//Instanciar uma lista de veiculos
		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		//Adicionar dois veiculos na lista
		lista.add(new Veiculo("Golzinho", "1232392193", Combustivel.GASOLINA));
		lista.add(new Veiculo("Uno", "892743232", Combustivel.ELETRICO));
		
		//Setar a lista na locacao
		locacao.setVeiculos(lista);
		
		//Adiciona a locação no contrato
		locacao.setContrato(contrato);
		
		//Adiciona a locação no cliente
		cliente.addLocacao(locacao);
		
		//Persistir o cliente
		dao.cadastrar(cliente);
		try {
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		/*
		//Pesquisar o contrato
		Contrato c = em.find(Contrato.class, 1);
		
		//Exibir a data de inicio
		System.out.println(c.getDataInicio().getTime());
		
		//Exibir o valor da locação
		System.out.println(c.getLocacao().getValor());
		*/
		
		//fechar
		em.close();
		fabrica.close();
		
	}
	
}
