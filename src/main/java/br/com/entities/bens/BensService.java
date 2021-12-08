package br.com.entities.bens;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class BensService implements ServiceCRUD<BensEntity>{

	@Autowired
	private BensRepository bensRepository;

	@Override
	public BensEntity cadastrar(BensEntity entity) {
		return bensRepository.save(entity);
	}

	@Override
	public BensEntity buscarPorId(Long id) {
		Optional<BensEntity> entity = bensRepository.findById(id);
		return entity.orElse(null);
	}

	@Override
	public BensEntity alterar(BensEntity entity, Long id) {
		return bensRepository.findById(id).map(bens -> {
			bens.setValor(entity.getValor());
			bens.setTipoBens(entity.getTipoBens());
			return bensRepository.save(bens);
		}).orElse(null);
	}

	@Override
	public void deletar(BensEntity entity) {
		bensRepository.delete(entity);
		
	}

	@Override
	public Collection<BensEntity> buscarTodos() {
		return bensRepository.findAll();
	}
}
