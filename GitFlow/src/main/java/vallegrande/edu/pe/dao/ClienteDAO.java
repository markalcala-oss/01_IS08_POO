package vallegrande.edu.pe.dao;

import vallegrande.edu.pe.modelo.Conexion;
import vallegrande.edu.pe.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDni(rs.getString("dni"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error listar cliente: " + e.getMessage());
        }
        return lista;
    }

    public int agregar(Cliente c) {
        String sql = "INSERT INTO cliente (nombre, dni, telefono) VALUES (?,?,?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getTelefono());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
