package br.com.padawan.dao.impl;

import javax.persistence.EntityManager;

import br.com.padawan.dao.UsuarioDAO;
import br.com.padawan.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
