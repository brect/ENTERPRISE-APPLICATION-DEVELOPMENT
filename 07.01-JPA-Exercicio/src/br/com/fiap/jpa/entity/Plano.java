package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLANO")
@SequenceGenerator(name="TB_PLANO", allocationSize = 1, sequenceName = "SQ_TB_PLANO")
public class Plano {

	@Id
	@Column(name="cd_plano")
	@GeneratedValue(generator = "cd_plano", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_plano", nullable = false, length = 20)
	private String nome;
	
	@Column(name="vl_plano", nullable = false)
	private float valor;
	
	@OneToMany(mappedBy = "plano")
	private List<Contrato> contratos;
	
	public Plano(String nome, float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Plano() {
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
}
