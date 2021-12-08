package br.com.entities.pessoa;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class PessoaService implements ServiceCRUD<PessoaEntity>{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaEntity cadastrar(PessoaEntity entity) {
		return pessoaRepository.save(entity);
	}

	public void deletar(PessoaEntity entity) {
		pessoaRepository.delete(entity);
	}
	
	public PessoaEntity buscarPorId(Long id){
		Optional<PessoaEntity> entity = pessoaRepository.findById(id);
		return entity.orElse(null);
	}
	
	public Collection<PessoaEntity> buscarTodos(){
		return pessoaRepository.findAll();
	}
	
	public PessoaEntity alterar(PessoaEntity entity, Long id) {
		return pessoaRepository.findById(id)
				.map(pessoa -> {
					pessoa.setNome(entity.getNome());
					pessoa.setIdade(entity.getIdade());
					pessoa.setEndereco(entity.getEndereco());
					pessoa.setTipoFonteRenda(entity.getTipoFonteRenda());
					return pessoaRepository.save(pessoa);
				}).orElse(null);
	}
	
}
