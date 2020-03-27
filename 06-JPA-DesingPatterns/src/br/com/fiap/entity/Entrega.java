package br.com.fiap.entity;

import java.util.Calendar;
import java.util.Date;

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

/*

 * TB_ENTREGA
 * *cd_entrega NUMBER PK
 *  *dt_entrega DATETIME
 *  *ds_responsavel VARCHAR(50)
 *  *ds_status VARCHAR (Enum no Java)
 */

@Entity()
@Table(name="TB_ENTREGA")
@SequenceGenerator(name = "entrega", sequenceName = "SQ_TB_ENTREGA", allocationSize = 1)
public class Entrega {

	@Id
	@Column(name="cd_entrega")
	@GeneratedValue(generator = "entrega", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrega", nullable = false)
	private Calendar entrega;

	@Column(name="ds_responsavel", nullable = false, length = 50)
	private String responsavel;

	@Column(name="ds_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Entrega() {
		super();
	}


	public Entrega(Calendar entrega, String responsavel, Status status) {
		super();
		this.entrega = entrega;
		this.responsavel = responsavel;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Calendar getEntrega() {
		return entrega;
	}


	public void setEntrega(Calendar entrega) {
		this.entrega = entrega;
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
