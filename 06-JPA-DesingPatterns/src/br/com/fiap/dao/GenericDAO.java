package br.com.fiap.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.ResourceNotFoundException;

public interface GenericDAO <T, K>{
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T buscar(K codigo);
	
	void deletar(K codigo) throws ResourceNotFoundException;
	
	void commit() throws CommitException;
}
