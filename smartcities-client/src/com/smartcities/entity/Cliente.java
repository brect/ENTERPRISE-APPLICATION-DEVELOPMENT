package com.smartcities.entity;

import java.io.Serializable;

public class Cliente implements Serializable{

	private int id;
	private String nome;
	

	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	

	public Cliente() {
		super();
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
