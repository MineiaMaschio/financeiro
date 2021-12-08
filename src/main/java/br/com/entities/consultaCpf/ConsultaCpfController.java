package br.com.entities.consultaCpf;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.entities.empresa.EmpresaEntity;
import br.com.entities.empresa.EmpresaService;
import br.com.entities.pessoa.PessoaEntity;
import br.com.entities.pessoa.PessoaService;

@RestController
public class ConsultaCpfController {

	@Autowired
	private ConsultaCpfService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/consulta/pessoa/{pessoaId}/empresa/{empresaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultaCpfEntity> cadastrar(@PathVariable (value = "pessoaId") Long pessoaId,
			  										   @PathVariable (value = "empresaId") Long empresaId,
			  										   @RequestBody ConsultaCpfEntity entity) throws Exception {
		EmpresaEntity empresaEntity = empresaService.buscarPorId(empresaId);
		PessoaEntity pessoaEntity = pessoaService.buscarPorId(pessoaId);
		if (empresaEntity == null || pessoaEntity == null) {
			throw new Exception("Empresa ou pessoa não existe");
		}
		entity.setPessoa(pessoaEntity);
		entity.setEmpresa(empresaEntity);
		ConsultaCpfEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<ConsultaCpfEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/consulta/{id}")
	public ResponseEntity<ConsultaCpfEntity> alterar(@RequestBody ConsultaCpfEntity entity, @PathVariable Long id) {
		ConsultaCpfEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<ConsultaCpfEntity>(entityAlterado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/consulta/{id}")
	public ResponseEntity<ConsultaCpfEntity> deletar(@PathVariable Long id) {
		ConsultaCpfEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<ConsultaCpfEntity>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consulta/{id}")
	public ResponseEntity<ConsultaCpfEntity> buscarPorId(@PathVariable Long id) {
		ConsultaCpfEntity entity = service.buscarPorId(id);
		return new ResponseEntity<ConsultaCpfEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consulta")
	public ResponseEntity<Collection<ConsultaCpfEntity>> buscarTodos() {
		Collection<ConsultaCpfEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
