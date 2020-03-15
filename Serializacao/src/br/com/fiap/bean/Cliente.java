package br.com.fiap.bean;

import java.io.Serializable;

public class Cliente implements Serializable{


	private static final long serialVersionUID = -6387852002905787492L;
	
	private int id;
	private String nome;
	
	
	public Cliente() {
		super();
	}
	
	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
