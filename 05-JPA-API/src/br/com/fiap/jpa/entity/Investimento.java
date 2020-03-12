package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 TB_INVESTIMENTO
	*cd_investimento NUMBER (PK)
	*nm_investimento VARCHAR(50)
	*ds_tipo VARCHAR (Enum no Java)
	dt_aquisicao DATE (Calendar no java)
	vl_investimento_inical FLOAT
 */

@Entity
@Table(name="TB_INVESTIMENTO")
@SequenceGenerator(name="inv", sequenceName = "SQ_TB_INVESTIMENTO", allocationSize = 1)
public class Investimento {

	@Id
	@Column(name="cd_investimento")
	@GeneratedValue(generator = "inv", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_investimento", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_aquisicao")
	private Calendar dataAquisicao;
	
	@Column(name="vl_investimento")
	private double valor;
	
	public Investimento() {
		super();
	}

	public Investimento(String nome, Tipo tipo, Calendar dataAquisicao, double valor) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.dataAquisicao = dataAquisicao;
		this.valor = valor;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
