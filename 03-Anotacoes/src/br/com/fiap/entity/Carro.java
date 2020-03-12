package br.com.fiap.entity;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome="TB_CARRO")
public class Carro {

	@Coluna(nome="ds_modelo", obrigatorio = true)
	private String modelo;
	
	@Coluna(nome="ds_ano")
	private int ano;
	
	@Coluna(nome="ds_cor")
	private String cor;
	
	@Coluna(nome="nr_chassi", obrigatorio = true)
	private String chassi;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
}