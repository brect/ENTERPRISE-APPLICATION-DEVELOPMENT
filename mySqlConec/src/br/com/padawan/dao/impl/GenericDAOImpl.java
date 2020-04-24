package br.com.padawan.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.padawan.dao.GenericDAO;
import br.com.padawan.exception.CommitException;
import br.com.padawan.exception.ResourceNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{

	private EntityManager entityManager;
	private Class<T> entity;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		this.entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public void alterar(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public T pesquisar(K key) {
		return entityManager.find(entity, key);
	}

	@Override
	public void deletar(K key) throws ResourceNotFoundException {
		T entity = pesquisar(key);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		entityManager.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}
}
