package br.com.fiap.teste;

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

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

class PedidoDAOTest {

	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;
	static PedidoDAO pedidoDao;
	Pedido pedido;
	
	@BeforeAll
	static void inicializar() {
		entityManagerFactory = Persistence.createEntityManagerFactory("teste");
		entityManager = entityManagerFactory.createEntityManager();
		pedidoDao = new PedidoDAOImpl(entityManager);
	}

	@AfterAll
	static void finalizar() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@BeforeEach
	void cadastrar() {
		pedido = new Pedido("Pizza", 20, 1, Calendar.getInstance());
		pedidoDao.cadastrar(pedido);
		
		try {
			pedidoDao.commit();
		} catch (CommitException e) {
			fail("Falha ao testar cadastro");
		}
	}
	
	@Test
	@DisplayName("Deletar com sucesso")
	void deletarSucessoTeste() {
		try {
			pedidoDao.deletar(pedido.getCodigo());
			pedidoDao.commit();
		} catch (Exception e) {
			fail("Falha ao testar deletar");
		}
		Pedido buscar = pedidoDao.buscar(pedido.getCodigo());
		assertNull(buscar);
	}
	
	@Test
	@DisplayName("Deletar com chave inexistente no banco de dados")
	void deletarChaveInvalidaTeste() {
		assertThrows(ResourceNotFoundException.class, () -> pedidoDao.deletar(-1));
	}
	
	@Test
	@DisplayName("Buscar um pedido com sucesso")
	void buscarSucessoTest() {
		Pedido buscar = pedidoDao.buscar(pedido.getCodigo());
		assertNotNull(buscar);
		assertEquals(buscar.getCodigo(), pedido.getCodigo());
	}
	
	@Test
	@DisplayName("Atualizar um pedido com sucesso")
	void atualizarSucessoTeste() {
		pedido.setProduto("Xurupita");
		pedidoDao.atualizar(pedido);
		
		try {
			pedidoDao.commit();
		} catch (Exception e) {
			fail("Falha no teste de atualizar");
		}
		Pedido buscar = pedidoDao.buscar(pedido.getCodigo());
		assertEquals(pedido.getProduto(), buscar.getProduto());
	}
	
	@Test
	@DisplayName("Cadastrar um pedido com sucesso")
	void cadastrarSucessoTeste() {
		assertNotEquals(0,  pedido.getCodigo());
	}

}
