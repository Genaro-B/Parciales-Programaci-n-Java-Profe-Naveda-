package Persistencia;
import Modelo.Alumno;
import java.util.List;

public interface AlumnoDAO extends GenericDAO<Alumno, Integer> {
    // Buscar alumnos por nombre (ejemplo de consulta personalizada)
    List<Alumno> buscarPorNombre(String nombre) throws Exception;

    // Listar alumnos por id de curso
    List<Alumno> listarPorCursoId(int cursoId) throws Exception;
}