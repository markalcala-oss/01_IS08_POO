package vallegrande.edu.pe.model;

import vallegrande.edu.pe.conexion_BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Importante para leer datos
import java.sql.SQLException;
import java.util.ArrayList; // Para manejar la lista
import java.util.List;      // Para manejar la lista

public class PlatoDAO {

    // 1. MÉTODO PARA REGISTRAR (CREATE)
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

    // 2. MÉTODO PARA LISTAR (READ) - ESTO ES LO NUEVO
    public List<Plato> listar() {
        List<Plato> lista = new ArrayList<>();
        String sql = "SELECT * FROM platos";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Plato p = new Plato();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCategoria(rs.getString("categoria"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar platos: " + e.getMessage());
        }
        return lista;
    }
}
