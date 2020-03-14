package com.smartcities.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.*;
import java.util.List;

public class GenericDAO<Table, PrimaryKey> {

	protected EntityManager entityManager;
	private Class<Table> classe;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		classe = (Class<Table>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void cadastrar(Table entidade) {
		entityManager.persist(entidade);
	}
	
	public void atualizar(Table entidade) {
		entityManager.merge(entidade);
	}


	public Table buscar(PrimaryKey primaryKey) {
		return entityManager.find(classe, primaryKey);
	}

	public void remover(PrimaryKey primaryKey) throws Exception{
		Table entidade = buscar(primaryKey);
		if (entidade == null) {
			throw new Exception("Entidade não encontrada");
		}
		entityManager.remove(entidade);
	}
	
	public List<Table> listar(){
		return entityManager.createQuery("from" + classe.getName()).getResultList();
	}
	
	public void commit() throws Exception{
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw new Exception("Erro no commit");
		}
	}
	
}
