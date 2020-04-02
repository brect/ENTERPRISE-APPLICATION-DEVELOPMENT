package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{
	
	private EntityManager entityManager;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
																.getGenericSuperclass())
																.getActualTypeArguments()[0];
	}

	public void cadastrar(T entity) {
		entityManager.persist(entity);
	}

	public void atualizar(T entity) {
		entityManager.merge(entity);
	}
	
	public T pesquisar(K code) {
		return entityManager.find(entityClass, code);
	}
	
	public void deletar(K codigo) throws ResourceNotFoundException{
		T entity = pesquisar(codigo);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		entityManager.remove(entity);
	}
	
	public void commit() throws CommitException{
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new CommitException();
		}
	}

	@Override
	public T buscar(K code) {
		// TODO Auto-generated method stub
		return null;
	}
}
