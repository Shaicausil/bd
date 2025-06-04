package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String NOMBRE_BD = "MVC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + NOMBRE_BD;

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión exitosa a la BD: " + NOMBRE_BD);
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC no encontrado: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error de SQL: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void desconectar() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Desconectado de la BD: " + NOMBRE_BD);
            } catch (SQLException e) {
                System.err.println("Error al desconectar: " + e.getMessage());
            }
        }
    }
}

