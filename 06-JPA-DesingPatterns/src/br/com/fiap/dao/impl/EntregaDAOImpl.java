package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntregaDAO;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.entity.Entrega;
import br.com.fiap.entity.Pedido;

public class EntregaDAOImpl extends GenericDAOImpl<Entrega, Integer>implements EntregaDAO{

	public EntregaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
