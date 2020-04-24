package br.com.fiap.jpa.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;


class PedidoDAOTest {

	static EntityManagerFactory fabrica;
	static EntityManager em;
	static PedidoDAO dao;
	Pedido pedido;
	
	@BeforeAll //Método executado antes de todos os testes
	static void inicializar() {
		//Instanciando os objetos
		fabrica = Persistence.createEntityManagerFactory("teste");
		em = fabrica.createEntityManager();
		dao = new PedidoDAOImpl(em);
	}
	
	@AfterAll //Método executado após todos os testes
	static void finalizar() {
		em.close();
		fabrica.close();
	}
	
	@BeforeEach //Método executado antes de cada teste
	void cadastrar() {
		pedido = new Pedido("Pizza", 20, 1, Calendar.getInstance());
		
		//Chamando o método 
		dao.cadastrar(pedido);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste...");
		}
	}
	
	@Test
	@DisplayName("Atualizar o produto do pedido com sucesso")
	void atualizarSucessoTest() {
		//alterar os dados do pedido
		pedido.setProduto("Coca-Cola");
		
		dao.atualizar(pedido);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
		
		//validar se os dados foram alterados
		Pedido busca = dao.pesquisar(pedido.getCodigo());
		
		assertEquals(pedido.getProduto(), busca.getProduto());
	}
	
	@Test
	@DisplayName("Deletar com chave inexistente no banco de dados")
	void removerChaveInvalidaTest() {
		//Validar se o método deletar retorna a exceção ResourceNotFoundException
		assertThrows(ResourceNotFoundException.class, 
				() -> { dao.deletar(-1); });
	}
	
	@Test
	@DisplayName("Deletar com sucesso")
	void removerSucessoTest() {
		//remover
		try {
			dao.deletar(pedido.getCodigo());
			dao.commit();
		}catch(CommitException | ResourceNotFoundException e) {
			fail("Falha no teste");
		}
		//validar se removeu
		Pedido busca = dao.pesquisar(pedido.getCodigo());
		assertNull(busca);
	}
	
	@Test
	@DisplayName("Buscar um pedido com sucesso")
	void buscarSucessoTest() {
		//Pesquisar o pedido cadastrado
		Pedido busca = dao.pesquisar(pedido.getCodigo());
		
		//Validar se a pesquisa funcionou
		assertNotNull(busca);
		assertEquals(busca.getCodigo(), pedido.getCodigo());
	}
	
	@Test
	@DisplayName("Cadastrar com sucesso")
	void cadastrarSucessoTest() {
		//Validando se deu certo
		//Verifica se foi gerado um código para a PK 
		assertNotEquals(0, pedido.getCodigo());
	}

}
