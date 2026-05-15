package vallegrande.edu.pe.model;

import vallegrande.edu.pe.conexion_BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlatoDAO {

    // Método para Registrar un Plato (Create del CRUD)
    public boolean registrar(Plato plato) {
        String sql = "INSERT INTO platos (nombre, precio, categoria) VALUES (?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, plato.getNombre());
            ps.setDouble(2, plato.getPrecio());
            ps.setString(3, plato.getCategoria());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar plato: " + e.getMessage());
            return false;
        }
    }
}
