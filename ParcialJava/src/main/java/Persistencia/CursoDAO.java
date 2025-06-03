package Persistencia;

import Modelo.Curso;
import java.util.List;

public interface CursoDAO extends GenericDAO<Curso, Integer> {
    // Buscar cursos por nombre (consulta personalizada)
    List<Curso> buscarPorNombre(String nombre) throws Exception;
}
