package br.com.entities.empresa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empresa")
public class EmpresaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empresa_seq")
	@SequenceGenerator(name = "empresa_seq", sequenceName = "empresa_seq", allocationSize = 1, initialValue = 1)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String cnpj;

	@NotNull
	private String telefone;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
