package vallegrande.edu.pe.conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Para local siempre es 127.0.0.1 o localhost
    private static final String URL = "jdbc:mysql://localhost:3306/restaurante_db";
    private static final String USER = "root"; // Usuario por defecto de MySQL
    private static final String PASS = "1233"; // LA QUE PUSISTE AL INSTALAR MYSQL

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("¡Conexión Exitosa Local!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
}