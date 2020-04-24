package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K id);
	
	void deletar(K id) throws ResourceNotFoundException;
	
	void commit() throws CommitException;
	
}