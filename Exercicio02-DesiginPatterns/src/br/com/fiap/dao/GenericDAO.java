package br.com.fiap.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;

public interface GenericDAO <T, K>{

	void cadastrar(T entity);
	
	void atualizar(T entity);
	
	T buscar(K code);
	
	void deletar(K code) throws ResourceNotFoundException;
	
	void commit() throws CommitException;
}

