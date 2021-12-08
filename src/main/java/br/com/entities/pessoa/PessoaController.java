package br.com.entities.pessoa;

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

import br.com.financeiro.ControllerCRUD;

@RestController(value = "/")
public class PessoaController implements ControllerCRUD<PessoaEntity> {

	@Autowired
	private PessoaService service;

	@RequestMapping(method = RequestMethod.POST, value = "/pessoa", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaEntity> cadastrar(@RequestBody PessoaEntity entity) {
		PessoaEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<PessoaEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/pessoa/{id}")
	public ResponseEntity<PessoaEntity> alterar(@RequestBody PessoaEntity entity, @PathVariable Long id) {
		PessoaEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<PessoaEntity>(entityAlterado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pessoa/{id}")
	public ResponseEntity<PessoaEntity> deletar(@PathVariable Long id) {
		PessoaEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<PessoaEntity>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pessoa/{id}")
	public ResponseEntity<PessoaEntity> buscarPorId(@PathVariable Long id) {
		PessoaEntity entity = service.buscarPorId(id);
		return new ResponseEntity<PessoaEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pessoa")
	public ResponseEntity<Collection<PessoaEntity>> buscarTodos() {
		Collection<PessoaEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
