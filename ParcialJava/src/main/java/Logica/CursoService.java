package Logica;

import Modelo.Curso;
import Persistencia.CursoDAO;
import Persistencia.CursoDAOImpl;

import java.util.List;

public class CursoService {
    private CursoDAO cursoDAO = new CursoDAOImpl();

    public void crearCurso(Curso curso) throws Exception {
        if (curso.getNombre() == null || curso.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
        }
        cursoDAO.crear(curso);
    }

    public Curso buscarCursoPorId(int id) throws Exception {
        return cursoDAO.buscarPorId(id);
    }

    public List<Curso> listarCursos() throws Exception {
        return cursoDAO.listarTodos();
    }

    public void actualizarCurso(Curso curso) throws Exception {
        cursoDAO.actualizar(curso);
    }

    public void eliminarCurso(int id) throws Exception {
        cursoDAO.eliminar(id);
    }
}