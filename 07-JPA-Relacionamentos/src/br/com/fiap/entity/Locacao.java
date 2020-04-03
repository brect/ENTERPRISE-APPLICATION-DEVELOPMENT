package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCACAO")
@SequenceGenerator(name="locacao", sequenceName = "SQ_TB_LOCACAO", allocationSize=1)
public class Locacao {

	@Id
	@Column(name = "cd_locacao", nullable = false)
	@GeneratedValue(generator = "locacao", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne(mappedBy = "locacao", cascade = CascadeType.ALL)
	private Contrato contrato;
	
	@Column(name = "vl_locacao", nullable = false)
	private double valor;
	
	private Cliente cliente;
	
	@Column(name = "ds_tipo")
	private TipoLocacao tipoLocacao;

}
