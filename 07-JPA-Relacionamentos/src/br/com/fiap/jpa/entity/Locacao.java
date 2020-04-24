package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_LOCACAO")
@SequenceGenerator(name="locacao", sequenceName = "SQ_TB_LOCACAO", allocationSize = 1)
public class Locacao {

	@Id
	@Column(name="cd_locacao")
	@GeneratedValue(generator = "locacao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="vl_locacao")
	private double valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoLocacao tipo;
	
	//Mapear o relacionamento bidirecional one-to-one
	//mappedBy -> sempre será utilizada no relacionamento bidirecional
	//mappedBy -> nome do atributo que mapeia a relação (FK) (Na classe Contrato)
	@OneToOne(mappedBy = "locacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Contrato contrato;
	
	//Da classe que estamos para a classe da relação
	@ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="cd_cliente", nullable = false)
	private Cliente cliente;
	
	//JoinTable name -> nome da tabela associativa
	//joinColumns -> coluna que armazena a chave da "tabela" que estamos
	//inverseJoinColumns -> coluna que armazena a chave do outro lado da relação
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_VEICULO_LOCACAO",
			joinColumns = @JoinColumn(name="cd_locacao"),
			inverseJoinColumns = @JoinColumn(name="cd_veiculo"))
	private List<Veiculo> veiculos;
	
	public Locacao(double valor, TipoLocacao tipo) {
		super();
		this.valor = valor;
		this.tipo = tipo;
	}

	public Locacao() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoLocacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocacao tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
