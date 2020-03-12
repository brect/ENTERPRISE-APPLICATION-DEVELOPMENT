package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.InvestimentoDAO;
import br.com.fiap.jpa.entity.Investimento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEncontradaException;

public class InvestimentoDAOImpl implements InvestimentoDAO {

	private EntityManager em;
	
	//Construtor que recebe o entity manager
	public InvestimentoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Investimento investimento) {
		em.persist(investimento);
	}

	@Override
	public void atualizar(Investimento investimento) {
		em.merge(investimento);
	}

	@Override
	public void deletar(int codigo) throws EntidadeNaoEncontradaException {
		Investimento investimento = buscar(codigo);
		//Validar se existe um investimento cadastrado no banco
		if (investimento == null) {
			throw new EntidadeNaoEncontradaException();
		}
		em.remove(investimento);
	}

	@Override
	public Investimento buscar(int codigo) {
		return em.find(Investimento.class, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
}
