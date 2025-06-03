package Utilidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos MySQL.
 */
public class Conexion {

    // URL de conexión, incluye dirección, puerto y nombre de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC"
            ;

    // Usuario para conectarse a la base de datos
    private static final String USER = "root";

    // Contraseña del usuario
    private static final String PASSWORD = "";

    /**
     * Método estático que crea y devuelve una conexión nueva a la base de datos.
     * @return Connection: objeto que representa la conexión activa.
     * @throws SQLException si la conexión falla.
     */
    public static Connection obtenerConexion() throws SQLException {
        // DriverManager obtiene la conexión con la URL, usuario y contraseña indicados
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC"
                ,"root", "");
    }
}

