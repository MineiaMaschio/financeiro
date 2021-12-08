package br.com.entities.divida;

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
public class DividaController {

	@Autowired
	private DividaService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/divida/pessoa/{pessoaId}/empresa/{empresaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DividaEntity> cadastrar(@PathVariable (value = "pessoaId") Long pessoaId,
												  @PathVariable (value = "empresaId") Long empresaId,
												  @RequestBody DividaEntity entity) throws Exception {
		
		EmpresaEntity empresaEntity = empresaService.buscarPorId(empresaId);
		PessoaEntity pessoaEntity = pessoaService.buscarPorId(pessoaId);
		if (empresaEntity == null || pessoaEntity == null) {
			throw new Exception("Empresa ou pessoa não existe");
		}
		entity.setPessoa(pessoaEntity);
		entity.setEmpresa(empresaEntity);
		DividaEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<DividaEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/divida/{id}")
	public ResponseEntity<DividaEntity> alterar(@RequestBody DividaEntity entity, @PathVariable Long id) {
		DividaEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<DividaEntity>(entityAlterado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/divida/{id}")
	public ResponseEntity<DividaEntity> deletar(@PathVariable Long id) {
		DividaEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<DividaEntity>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/divida/{id}")
	public ResponseEntity<DividaEntity> buscarPorId(@PathVariable Long id) {
		DividaEntity entity = service.buscarPorId(id);
		return new ResponseEntity<DividaEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/divida")
	public ResponseEntity<Collection<DividaEntity>> buscarTodos() {
		Collection<DividaEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
