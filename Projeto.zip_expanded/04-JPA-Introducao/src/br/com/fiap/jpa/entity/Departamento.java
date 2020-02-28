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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="TB_DEPARTAMENTO")
@SequenceGenerator(sequenceName = "SQ_TB_DEPARTAMENTO", name="dpto", allocationSize = 1)
public class Departamento {

	@Id
	@Column(name="cd_departamento")
	@GeneratedValue(generator = "dpto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_departamento", nullable = false, length = 20)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Calendar dataCriacao;
	
	@Column(name="nr_centro_curto")
	private int centroDeCusto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_segmento")
	private Segmento segmento;
	
	@Lob
	@Column(name="fl_foto_diretor")
	private byte[] fotoDiretor;

	@Transient
	private double mediaSalarial;
	
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(int centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	public byte[] getFotoDiretor() {
		return fotoDiretor;
	}

	public void setFotoDiretor(byte[] fotoDiretor) {
		this.fotoDiretor = fotoDiretor;
	}

	public double getMediaSalarial() {
		return mediaSalarial;
	}

	public void setMediaSalarial(double mediaSalarial) {
		this.mediaSalarial = mediaSalarial;
	}
}
