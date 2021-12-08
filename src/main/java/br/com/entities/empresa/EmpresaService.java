package br.com.entities.empresa;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.ServiceCRUD;

@Service
public class EmpresaService implements ServiceCRUD<EmpresaEntity> {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public EmpresaEntity cadastrar(EmpresaEntity entity) {
		return empresaRepository.save(entity);
	}

	@Override
	public EmpresaEntity buscarPorId(Long id) {
		Optional<EmpresaEntity> entity = empresaRepository.findById(id);
		return entity.orElse(null);
	}

	@Override
	public EmpresaEntity alterar(EmpresaEntity entity, Long id) {
		return empresaRepository.findById(id).map(empresa -> {
			empresa.setNome(entity.getNome());
			empresa.setTelefone(entity.getTelefone());
			empresa.setCnpj(entity.getCnpj());
			return empresaRepository.save(empresa);
		}).orElse(null);
	}

	@Override
	public void deletar(EmpresaEntity entity) {
		empresaRepository.delete(entity);

	}

	@Override
	public Collection<EmpresaEntity> buscarTodos() {
		return empresaRepository.findAll();
	}

}
