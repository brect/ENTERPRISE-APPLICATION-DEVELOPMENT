package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.InvestimentoDAO;
import br.com.fiap.jpa.dao.impl.InvestimentoDAOImpl;
import br.com.fiap.jpa.entity.Investimento;
import br.com.fiap.jpa.entity.Tipo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEncontradaException;

public class ConsoleView {

	public static void main(String[] args) {
		//Instanciar a fabrica
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		//Instanciar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o InvestimentoDAOImpl
		InvestimentoDAO dao = new InvestimentoDAOImpl(em);
		
		//Cadastrar um investimento
		Investimento inv = new Investimento("Tesouro Selic 2025",
				Tipo.TESOURO_DIRETO, Calendar.getInstance(), 1000);
		
		try {
			dao.cadastrar(inv);
			dao.commit();
			System.out.println("Investimento cadastrado!");
		} catch (CommitException e) {
			System.err.print("Erro ao cadastrar");
		} 
		
		//Pesquisar um investimento
		Investimento busca = dao.buscar(inv.getCodigo());
		System.out.println(busca.getNome());
		
		//Atualizar
		try {
			busca.setValor(5000);
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Investimento atualizado!");
		} catch (CommitException e) {
			System.err.print("Erro ao atualizar");
		}
		
		//Remover
		try {
			dao.deletar(1);
			dao.commit();
			System.out.println("Investimento removido");
		} catch(CommitException e) {
			System.err.println("Erro ao remover");
		} catch (EntidadeNaoEncontradaException e) {
			System.err.println("Investimento não encontrado");
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}

