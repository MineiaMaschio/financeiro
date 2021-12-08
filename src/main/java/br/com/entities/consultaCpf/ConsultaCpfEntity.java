package br.com.entities.consultaCpf;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.entities.empresa.EmpresaEntity;
import br.com.entities.pessoa.PessoaEntity;

@Entity
@Table(name = "consulta_cpf")
public class ConsultaCpfEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "consulta_cpf_seq")
	@SequenceGenerator(name = "consulta_cpf_seq", sequenceName = "consulta_cpf_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private PessoaEntity pessoa;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private EmpresaEntity empresa;
	
	@Column(name = "data_consulta")
	@NotNull
	private LocalDateTime dataConsulta;

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

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	
}
