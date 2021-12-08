package br.com.entities.movimentacao;

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
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(method = RequestMethod.POST, value = "/movimentacao/pessoa/{pessoaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovimentacaoEntity> cadastrar(@PathVariable (value = "pessoaId") Long pessoaId,
		    											@RequestBody MovimentacaoEntity entity) throws Exception {
		PessoaEntity pessoaEntity = pessoaService.buscarPorId(pessoaId);
		if (pessoaEntity == null) {
			throw new Exception("Pessoa não existe");
		}
		entity.setPessoa(pessoaEntity);
		MovimentacaoEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<MovimentacaoEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/movimentacao/{id}")
	public ResponseEntity<MovimentacaoEntity> alterar(@RequestBody MovimentacaoEntity entity, @PathVariable Long id) {
		MovimentacaoEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<MovimentacaoEntity>(entityAlterado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/movimentacao/{id}")
	public ResponseEntity<MovimentacaoEntity> deletar(@PathVariable Long id) {
		MovimentacaoEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<MovimentacaoEntity>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/movimentacao/{id}")
	public ResponseEntity<MovimentacaoEntity> buscarPorId(@PathVariable Long id) {
		MovimentacaoEntity entity = service.buscarPorId(id);
		return new ResponseEntity<MovimentacaoEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/movimentacao")
	public ResponseEntity<Collection<MovimentacaoEntity>> buscarTodos() {
		Collection<MovimentacaoEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}
}
