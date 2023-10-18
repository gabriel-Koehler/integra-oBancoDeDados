package net.weg.api.repository;

import java.util.Set;

public interface ICRUD<T,ID> extends AutoCloseable{

    void inserir(T objeto);
    T buscar(ID id);
    Set<T> buscarTodos();
    void atualizar(T objeto);
    void deletar(ID id);

}
