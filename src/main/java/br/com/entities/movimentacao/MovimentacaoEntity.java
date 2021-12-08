package br.com.entities.movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "movimentacao")
public class MovimentacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "movimentacao_seq")
	@SequenceGenerator(name = "movimentacao_seq", sequenceName = "movimentacao_seq", allocationSize = 1, initialValue = 1)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private PessoaEntity pessoa;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo")
	private TipoMovimentacao tipoMovimentacao;

	@Column(name = "data_movimentacao")
	@NotNull
	private LocalDateTime dataMovimentacao;

	@Column
	@NotNull
	private BigDecimal valor;

	
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

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
