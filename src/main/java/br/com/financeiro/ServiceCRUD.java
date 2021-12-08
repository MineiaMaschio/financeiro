package br.com.financeiro;

import java.util.Collection;

public interface ServiceCRUD<T> {
	T cadastrar(T entity);

	T buscarPorId(Long id);

	T alterar(T entity, Long id);

	void deletar(T entity);
	
	Collection<T> buscarTodos();
}
