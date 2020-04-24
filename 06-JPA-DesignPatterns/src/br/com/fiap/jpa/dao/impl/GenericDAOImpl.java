package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	private EntityManager em;
	
	//recupera o .class de T em tempo de execução (para a pesquisa)
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
																	.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T pesquisar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void deletar(K id) throws ResourceNotFoundException {
		T entidade = pesquisar(id);
		if (entidade == null) {
			throw new ResourceNotFoundException();
		}
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}
	
}