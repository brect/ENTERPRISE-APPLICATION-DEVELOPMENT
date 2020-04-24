package br.com.padawan.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.padawan.dao.UsuarioDAO;
import br.com.padawan.dao.impl.UsuarioDAOImpl;
import br.com.padawan.entity.Usuario;
import br.com.padawan.singleton.EntityManagerFactorySingleton;

public class ConsoleViewTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("entityManager : " + entityManager);
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(entityManager);
		
		for (int i = 1; i < 10; i++) {
			Usuario usuario = new Usuario("Usuario " + i, "usuario " + i + "@gmail.com");
			
			try {
				usuarioDAO.cadastrar(usuario);
				usuarioDAO.commit();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
