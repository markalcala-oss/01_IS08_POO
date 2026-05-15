package vallegrande.edu.pe.conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Cambia 'tu_ip_de_ubuntu' por la IP real de tu servidor
    private static final String URL = "jdbc:mysql://tu_ip_de_ubuntu:3306/restaurante_db";
    private static final String USER = "admin_restaurante"; // El usuario que creamos
    private static final String PASS = "TuPasswordSegura"; // Tu contraseña

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("¡Conexión exitosa a la nube!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
}