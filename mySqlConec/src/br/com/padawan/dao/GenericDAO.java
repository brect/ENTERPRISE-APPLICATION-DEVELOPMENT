package br.com.padawan.dao;

import br.com.padawan.exception.CommitException;
import br.com.padawan.exception.ResourceNotFoundException;

public interface GenericDAO <T, K> {

	void cadastrar(T entity);

	void alterar(T entity);
	
	T pesquisar(K key);

	void deletar(K key) throws ResourceNotFoundException;
	
	void commit() throws CommitException;	
}
