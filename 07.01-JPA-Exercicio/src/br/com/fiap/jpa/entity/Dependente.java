package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEPENDENTE")
@SequenceGenerator(name="dep", sequenceName = "SQ_TB_DEPENDENTE", allocationSize = 1)
public class Dependente {

	@Id
	@Column(name="cd_dependente")
	@GeneratedValue(generator = "dep", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_dependente", nullable = false, length = 80)
	private String nome;
	
	@OneToOne
	@JoinColumn(name="cd_contrato", nullable = false, unique = true)
	private Contrato contrato;
	
	public Dependente(String nome) {
		super();
		this.nome = nome;
	}

	public Dependente() {
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

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
}
