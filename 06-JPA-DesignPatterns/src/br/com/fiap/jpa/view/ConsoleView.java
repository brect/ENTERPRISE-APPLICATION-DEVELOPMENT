package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PedidoDAO dao = new PedidoDAOImpl(em);
		
		Pedido pedido = new Pedido("Arroz", 10, 1, Calendar.getInstance());
		
		//cadastrar
		try {
			dao.cadastrar(pedido);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//pesquisar
		Pedido busca = dao.pesquisar(pedido.getCodigo());
		System.out.println(busca.getProduto());
		
		//atualizar
		busca.setProduto("Feijao");
		try {
			dao.atualizar(busca);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//remover
		try {
			dao.deletar(busca.getCodigo());
			dao.commit();
		} catch (ResourceNotFoundException | CommitException e) {
			e.printStackTrace();
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}