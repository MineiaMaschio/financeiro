package br.com.entities.pessoa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.entities.bens.BensEntity;
import br.com.entities.divida.DividaEntity;
import br.com.entities.movimentacao.MovimentacaoEntity;


@Entity
@Table(name = "pessoa")
public class PessoaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pessoa_seq")
	@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1, initialValue = 1)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String endereco;

	@NotNull
	private Long idade;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "fonte_renda")
	private TipoFonteRenda tipoFonteRenda;
	
	@OneToMany(mappedBy = "pessoa")
	private List<DividaEntity> dividas;
	
	@OneToMany(mappedBy = "pessoa")
	private List<BensEntity> bens;
	
	@OneToMany(mappedBy = "pessoa")
	private List<MovimentacaoEntity> movimentacoes;

	//Getters and Setters
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public TipoFonteRenda getTipoFonteRenda() {
		return tipoFonteRenda;
	}

	public void setTipoFonteRenda(TipoFonteRenda tipoFonteRenda) {
		this.tipoFonteRenda = tipoFonteRenda;
	}
	
	

}
