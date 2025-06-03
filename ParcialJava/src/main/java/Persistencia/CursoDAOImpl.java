package Persistencia;

import Modelo.Curso;
import Utilidades.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

    @Override
    public void crear(Curso curso) throws Exception {
        String sql = "INSERT INTO cursos (id, nombre) VALUES (?, ?)";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, curso.getId());
            ps.setString(2, curso.getNombre());

            ps.executeUpdate(); // Ejecuta la inserción en la BD
        }
    }

    @Override
    public Curso buscarPorId(Integer id) throws Exception {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        Curso curso = null;

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int cursoId = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    curso = new Curso(cursoId, nombre);
                }
            }
        }

        return curso;
    }

    @Override
    public List<Curso> listarTodos() throws Exception {
        String sql = "SELECT * FROM cursos";
        List<Curso> lista = new ArrayList<>();

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int cursoId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lista.add(new Curso(cursoId, nombre));
            }
        }

        return lista;
    }

    @Override
    public void actualizar(Curso curso) throws Exception {
        String sql = "UPDATE cursos SET nombre = ? WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getId());

            ps.executeUpdate(); // Ejecuta la actualización en la BD
        }
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        String sql = "DELETE FROM cursos WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate(); // Ejecuta el borrado
        }
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre) throws Exception {
        String sql = "SELECT * FROM cursos WHERE nombre LIKE ?";
        List<Curso> lista = new ArrayList<>();

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int cursoId = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    lista.add(new Curso(cursoId, nom));
                }
            }
        }
        return lista;
    }
}
