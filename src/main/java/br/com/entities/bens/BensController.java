package br.com.entities.bens;
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

import br.com.entities.pessoa.PessoaEntity;
import br.com.entities.pessoa.PessoaService;

@RestController
public class BensController {

	@Autowired
	private BensService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/bens/pessoa/{pessoaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BensEntity> cadastrar(@PathVariable (value = "pessoaId") Long pessoaId,
											    @RequestBody BensEntity entity) throws Exception {
		PessoaEntity pessoaEntity = pessoaService.buscarPorId(pessoaId);
		if (pessoaEntity == null) {
			throw new Exception("Pessoa não existe");
		}
		entity.setPessoa(pessoaEntity);
		BensEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<BensEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/bens/{id}")
	public ResponseEntity<BensEntity> alterar(@RequestBody BensEntity entity, @PathVariable Long id) {
		BensEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<BensEntity>(entityAlterado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/bens/{id}")
	public ResponseEntity<BensEntity> deletar(@PathVariable Long id) {
		BensEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<BensEntity>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/bens/{id}")
	public ResponseEntity<BensEntity> buscarPorId(@PathVariable Long id) {
		BensEntity entity = service.buscarPorId(id);
		return new ResponseEntity<BensEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/bens")
	public ResponseEntity<Collection<BensEntity>> buscarTodos() {
		Collection<BensEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
