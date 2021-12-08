package br.com.entities.consultaCpf;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class ConsultaCpfService implements ServiceCRUD<ConsultaCpfEntity> {

	@Autowired
	private ConsultaCpfRepository consultaCpfRepository;
	
	@Override
	public ConsultaCpfEntity cadastrar(ConsultaCpfEntity entity) {
		return consultaCpfRepository.save(entity);
	}

	@Override
	public ConsultaCpfEntity buscarPorId(Long id) {
		Optional<ConsultaCpfEntity> entity = consultaCpfRepository.findById(id);
		return entity.orElse(null);
	}

	@Override
	public ConsultaCpfEntity alterar(ConsultaCpfEntity entity, Long id) {
		return consultaCpfRepository.findById(id).map(consulta -> {
			consulta.setDataConsulta(entity.getDataConsulta());
			return consultaCpfRepository.save(consulta);
		}).orElse(null);
	}

	@Override
	public void deletar(ConsultaCpfEntity entity) {
		consultaCpfRepository.delete(entity);
		
	}

	@Override
	public Collection<ConsultaCpfEntity> buscarTodos() {
		return consultaCpfRepository.findAll();
	}

}
