package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column(name = "cd_cliente", nullable = false)
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nm_cliente", nullable = false, length = 100)
	private String nome;
	
	@Lob
	@Column(name = "ft_cliente")
	private Byte[] foto;
	
	@Column(name = "ds_email", nullable = false, length = 80)
	private String email;
}
