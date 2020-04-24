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

@Entity
@Table(name="TB_ENTREGA")
@SequenceGenerator(name="entrega", sequenceName = "SQ_TB_ENTREGA", allocationSize = 1)
public class Entrega {
	
	@Id
	@Column(name="cd_entrega")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrega")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrega", nullable = false)
	private Calendar data;
	
	@Column(name="ds_responsavel", length = 50, nullable = false)
	private String responsavel;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_status", nullable = false)
	private Status status;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
