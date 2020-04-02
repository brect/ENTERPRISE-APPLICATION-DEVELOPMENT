package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		PedidoDAO pedidoDAO = new PedidoDAOImpl(entityManager);
		Pedido pedido = new Pedido("Arroz", 10, 1, Calendar.getInstance());
//		
//		try {
//			pedidoDAO.cadastrar(pedido);
//			pedidoDAO.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//pesquisar
		Pedido buscar = pedidoDAO.buscar(pedido.getCodigo());
		System.out.println(buscar.getProduto());
		
//		//atualizar
//		buscar.setProduto("Feijao");
//		try {
//			pedidoDAO.atualizar(buscar);
//			pedidoDAO.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			pedidoDAO.deletar(buscar.getCodigo());
//			pedidoDAO.commit();
//		} catch (CommitException | ResourceNotFoundException e) {
//			e.printStackTrace();
//		}
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
