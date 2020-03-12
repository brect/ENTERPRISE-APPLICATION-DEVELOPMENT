package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Investimento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEncontradaException;

public interface InvestimentoDAO {

	void cadastrar(Investimento investimento);
	
	void atualizar(Investimento investimento);
	
	void deletar(int codigo) throws EntidadeNaoEncontradaException;
	
	Investimento buscar(int codigo);
	
	void commit() throws CommitException;
	
}