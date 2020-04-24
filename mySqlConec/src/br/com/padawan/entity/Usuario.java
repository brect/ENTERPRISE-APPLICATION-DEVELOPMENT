package br.com.padawan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName="SQ_TB_USUARIO", initialValue=1, allocationSize=1)
public class Usuario {

	@Id
	@GeneratedValue( generator = "usuario", strategy = GenerationType.IDENTITY)

	@Column(name = "cd_usuario", nullable = false)
	private int id;

	@Column(name = "nm_usuario", nullable = false)
	private String nome;

	@Column(name = "ds_email", nullable = false)
	private String email;

	
	@OneToOne

	private Endereco endereco;
	

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
