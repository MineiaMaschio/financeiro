package br.com.entities.divida;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.entities.empresa.EmpresaEntity;
import br.com.entities.pessoa.PessoaEntity;

@Entity
@Table(name = "divida")
public class DividaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "divida_seq")
	@SequenceGenerator(name = "divida_seq", sequenceName = "divida_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private PessoaEntity pessoa;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private EmpresaEntity empresa;

	@Column
	private BigDecimal valor;
	
	@Column(columnDefinition = "boolean default false")
	private boolean pago;

	// Getters and Setters
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

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
}
