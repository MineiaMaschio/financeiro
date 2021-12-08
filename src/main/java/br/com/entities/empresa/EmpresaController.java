package br.com.entities.empresa;
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

@RestController
public class EmpresaController implements ControllerCRUD<EmpresaEntity>{

	@Autowired
	private EmpresaService service;
	
	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/empresa", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaEntity> cadastrar(@RequestBody EmpresaEntity entity) {
		EmpresaEntity entityCadastrado = service.cadastrar(entity);
		return new ResponseEntity<EmpresaEntity>(entityCadastrado, HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = "/empresa/{id}")
	public ResponseEntity<EmpresaEntity> alterar(@RequestBody EmpresaEntity entity, @PathVariable Long id) {
		EmpresaEntity entityAlterado = service.alterar(entity, id);
		return new ResponseEntity<EmpresaEntity>(entityAlterado, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.DELETE, value = "/empresa/{id}")
	public ResponseEntity<EmpresaEntity> deletar(@PathVariable Long id) {
		EmpresaEntity entity = service.buscarPorId(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deletar(entity);
		return new ResponseEntity<EmpresaEntity>(HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/empresa/{id}")
	public ResponseEntity<EmpresaEntity> buscarPorId(@PathVariable Long id) {
		EmpresaEntity entity = service.buscarPorId(id);
		return new ResponseEntity<EmpresaEntity>(entity, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/empresa")
	public ResponseEntity<Collection<EmpresaEntity>> buscarTodos() {
		Collection<EmpresaEntity> entities = service.buscarTodos();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
