package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_AULA")
@SequenceGenerator(name="aula", sequenceName = "SQ_TB_AULA", allocationSize = 1)
public class Aula {

	@Id
	@Column(name="cd_aula")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aula")
	private int codigo;
	
	@Column(name="nm_aula", nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_aula")
	private Calendar data;
	
	@ManyToMany(mappedBy = "aulas")
	private List<Cliente> clientes;
	
	public Aula(String nome, Calendar data) {
		super();
		this.nome = nome;
		this.data = data;
	}

	public Aula() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
