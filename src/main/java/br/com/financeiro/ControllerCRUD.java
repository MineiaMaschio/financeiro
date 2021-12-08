package br.com.financeiro;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

public interface ControllerCRUD<T> {

	ResponseEntity<T> cadastrar(T entity);

	ResponseEntity<T> alterar(T entity, Long id);

	ResponseEntity<T> deletar(Long id);

	ResponseEntity<T> buscarPorId(Long id);

	ResponseEntity<Collection<T>> buscarTodos();
}
