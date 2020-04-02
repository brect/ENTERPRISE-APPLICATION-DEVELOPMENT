package br.com.fiap.entity;

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

@Entity
@Table(name = "TB_MOTORISTA")
@SequenceGenerator(name = "motorista", sequenceName = "SQ_TB_MOTORISTA", allocationSize = 1)
public class Motorista {

	@Id
	@Column(name = "nr_carteira", nullable = false)
	@GeneratedValue(generator = "motorista", strategy = GenerationType.SEQUENCE)
	private int carteira;
	
	@Column(name = "nm_motorista", nullable = false, length = 150)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Calendar nascimento;
	
	@Column(name = "fl_carteira")
	private Byte[] foto;
	
	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Motorista() {
		super();
	}

	public Motorista(String nome, Calendar nascimento, Byte[] foto, Genero genero) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
