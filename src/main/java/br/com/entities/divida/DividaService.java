package br.com.entities.divida;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class DividaService implements ServiceCRUD<DividaEntity>{
	
	@Autowired
	private DividaRepository dividaRepository;

	@Override
	public DividaEntity cadastrar(DividaEntity entity) {
		return dividaRepository.save(entity);
	}

	@Override
	public DividaEntity buscarPorId(Long id) {
		Optional<DividaEntity> entity = dividaRepository.findById(id);
		return entity.orElse(null);
	}

	@Override
	public DividaEntity alterar(DividaEntity entity, Long id) {
		return dividaRepository.findById(id).map(divida -> {
			divida.setValor(entity.getValor());
			divida.setPago(entity.isPago());
			return dividaRepository.save(divida);
		}).orElse(null);
	}

	@Override
	public void deletar(DividaEntity entity) {
		dividaRepository.delete(entity);
	}

	@Override
	public Collection<DividaEntity> buscarTodos() {
		return dividaRepository.findAll();
	}

}
