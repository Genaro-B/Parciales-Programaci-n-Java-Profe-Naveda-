package Persistencia;

import java.util.List;

public interface GenericDAO <T,ID> {
    void crear(T t) throws Exception;
    T buscarPorId(ID id) throws Exception;
    List<T> listarTodos() throws Exception;
    void actualizar(T t) throws Exception;
    void eliminar(ID id) throws Exception;
}
