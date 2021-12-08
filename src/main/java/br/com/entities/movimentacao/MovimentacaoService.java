package br.com.entities.movimentacao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class MovimentacaoService implements ServiceCRUD<MovimentacaoEntity>{

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Override
	public MovimentacaoEntity cadastrar(MovimentacaoEntity entity) {
		return movimentacaoRepository.save(entity);
	}

	@Override
	public MovimentacaoEntity buscarPorId(Long id) {
		Optional<MovimentacaoEntity> entity = movimentacaoRepository.findById(id);
		return entity.orElse(null);
	}

	@Override
	public MovimentacaoEntity alterar(MovimentacaoEntity entity, Long id) {
		return movimentacaoRepository.findById(id).map(movimentacao -> {
			movimentacao.setDataMovimentacao(entity.getDataMovimentacao());
			movimentacao.setTipoMovimentacao(entity.getTipoMovimentacao());
			movimentacao.setValor(entity.getValor());
			return movimentacaoRepository.save(movimentacao);
		}).orElse(null);
	}

	@Override
	public void deletar(MovimentacaoEntity entity) {
		movimentacaoRepository.delete(entity);
	}

	@Override
	public Collection<MovimentacaoEntity> buscarTodos() {
		return movimentacaoRepository.findAll();
	}

}
