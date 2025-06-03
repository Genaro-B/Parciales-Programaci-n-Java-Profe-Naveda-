package Persistencia;

import Modelo.Alumno;
import Modelo.Curso;
import Utilidades.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public void crear(Alumno alumno) throws Exception {
        String sql = "INSERT INTO alumnos (id, nombre, curso_id) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, alumno.getId());
            ps.setString(2, alumno.getNombre());
            ps.setInt(3, alumno.getCurso().getId());

            ps.executeUpdate();
        }
    }

    @Override
    public Alumno buscarPorId(Integer id) throws Exception {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        Alumno alumno = null;

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int alumnoId = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int cursoId = rs.getInt("curso_id");

                    alumno = new Alumno(alumnoId, nombre, new Curso(cursoId, ""));
                }
            }
        }

        return alumno;
    }

    @Override
    public List<Alumno> listarTodos() throws Exception {
        String sql = "SELECT * FROM alumnos";
        List<Alumno> lista = new ArrayList<>();

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int alumnoId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int cursoId = rs.getInt("curso_id");
                lista.add(new Alumno(alumnoId, nombre, new Curso(cursoId, "")));
            }
        }

        return lista;
    }

    @Override
    public void actualizar(Alumno alumno) throws Exception {
        String sql = "UPDATE alumnos SET nombre = ?, curso_id = ? WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getCurso().getId());
            ps.setInt(3, alumno.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Alumno> buscarPorNombre(String nombre) throws Exception {
        String sql = "SELECT * FROM alumnos WHERE nombre LIKE ?";
        List<Alumno> lista = new ArrayList<>();

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int alumnoId = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    int cursoId = rs.getInt("curso_id");
                    lista.add(new Alumno(alumnoId, nom, new Curso(cursoId, "")));
                }
            }
        }
        return lista;
    }

    @Override
    public List<Alumno> listarPorCursoId(int cursoId) throws Exception {
        String sql = "SELECT * FROM alumnos WHERE curso_id = ?";
        List<Alumno> lista = new ArrayList<>();

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cursoId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int alumnoId = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    lista.add(new Alumno(alumnoId, nom, new Curso(cursoId, "")));
                }
            }
        }
        return lista;
    }
}
