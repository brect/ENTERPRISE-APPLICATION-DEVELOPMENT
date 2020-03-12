package br.com.fiap.orm;

import br.com.fiap.anotacao.Tabela;

public class Orm {

	public String gerarPesquisa(Object obj) {
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		return "SELECT * FROM " + anotacao.nome();
	}
	
}