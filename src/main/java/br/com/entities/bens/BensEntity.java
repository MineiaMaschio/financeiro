package br.com.entities.bens;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.entities.pessoa.PessoaEntity;

@Entity
@Table(name = "bens")
public class BensEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bens_seq")
	@SequenceGenerator(name = "bens_seq", sequenceName = "bens_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private PessoaEntity pessoa;
	
	@Column
	@NotNull
	private BigDecimal valor;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo")
	private TipoBens tipoBens;

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoBens getTipoBens() {
		return tipoBens;
	}

	public void setTipoBens(TipoBens tipoBens) {
		this.tipoBens = tipoBens;
	}
	
	
}
