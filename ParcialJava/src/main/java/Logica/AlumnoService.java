package Logica;

import Modelo.Alumno;
import Persistencia.AlumnoDAO;
import Persistencia.AlumnoDAOImpl;

import java.util.List;

public class AlumnoService {
    private AlumnoDAO alumnoDAO = new AlumnoDAOImpl();

    public void crearAlumno(Alumno alumno) throws Exception {
        // Aquí podrías agregar validaciones
        if (alumno.getNombre() == null || alumno.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del alumno no puede estar vacío");
        }
        alumnoDAO.crear(alumno);
    }

    public Alumno buscarAlumnoPorId(int id) throws Exception {
        return alumnoDAO.buscarPorId(id);
    }

    public List<Alumno> listarAlumnos() throws Exception {
        return alumnoDAO.listarTodos();
    }

    public void actualizarAlumno(Alumno alumno) throws Exception {
        alumnoDAO.actualizar(alumno);
    }

    public void eliminarAlumno(int id) throws Exception {
        alumnoDAO.eliminar(id);
    }
}
