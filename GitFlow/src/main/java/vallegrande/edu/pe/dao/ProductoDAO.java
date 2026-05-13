package vallegrande.edu.pe.dao;

import vallegrande.edu.pe.modelo.Conexion;
import vallegrande.edu.pe.modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 1. MÉTODO LISTAR (Para llenar la JTable)
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // 2. MÉTODO AGREGAR (Para el botón Guardar)
    public int agregar(Producto p) {
        String sql = "INSERT INTO producto (nombre, precio, stock) VALUES (?,?,?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            return ps.executeUpdate(); // Retorna 1 si tuvo éxito
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return 0;
        }
    }

    // 3. MÉTODO ACTUALIZAR (Para el botón Editar)
    public int actualizar(Producto p) {
        String sql = "UPDATE producto SET nombre=?, precio=?, stock=? WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return 0;
        }
    }

    // 4. MÉTODO ELIMINAR (Para el botón Eliminar)
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id=" + id;
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}