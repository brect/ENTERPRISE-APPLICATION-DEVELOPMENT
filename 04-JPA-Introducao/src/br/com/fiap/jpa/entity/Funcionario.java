package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_FUNCIONARIO")
//sequenceName -> nome da sequencia no banco de dados
//name -> nome da sequencia no java, utilizado no @GeneratedValue
//allocationSize -> incremento
@SequenceGenerator(sequenceName = "SQ_TB_FUNCIONARIO", name="func", allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="nr_matricula")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int matricula;

	@Column(name = "nm_funcionario", nullable = false, length = 50)
	private String nome;
	
	//grava a string e n�o a posi��o da constante
	@Enumerated(EnumType.STRING)
	@Column(name="ds_cargo")
	private Cargo cargo;
	
	@Column(name="vl_salario", nullable = false)
	private double salario;
	
	@Transient //n�o ser� mapeado para uma coluna no banco
	private double decimoTerceiro;
	
	@Column(name="dt_inicio", nullable = false)
	@Temporal(TemporalType.DATE) //armazena somente a data no bd
	private Calendar dataInicio;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, Cargo cargo, double salario, Calendar dataInicio, byte[] foto) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.dataInicio = dataInicio;
		this.foto = foto;
	}
	
	//M�todo executado ap�s um select
	@PostLoad
	public void carregarAposSelect() {
		System.out.println("Carregando o 13 sal�rio...");
		Calendar hoje = Calendar.getInstance();	
		
		//Valida se o funcionario entrou no ano corrente
		if (hoje.get(Calendar.YEAR) == 
				dataInicio.get(Calendar.YEAR)) {
			//Calcula os meses trabalhados
			int meses = 12 - dataInicio.get(Calendar.MONTH);
			decimoTerceiro = salario*meses/12;
		} else {
			decimoTerceiro = salario;
		}
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getDecimoTerceiro() {
		return decimoTerceiro;
	}

	public void setDecimoTerceiro(double decimoTerceiro) {
		this.decimoTerceiro = decimoTerceiro;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}



