package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

//Implementar o GenericDAO e GenericDAOImpl
//Implementar o Singleton (EntityManagerFactorySingleton)
//Implementar o DAO para as entidades

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K id) throws KeyNotFoundException;
	
	T buscar(K id);
	
	void commit() throws CommitException;
	
}