package vallegrande.edu.pe.controlador;

import vallegrande.edu.pe.dao.ProductoDAO;
import vallegrande.edu.pe.dao.ClienteDAO; // Necesitas crear este
import vallegrande.edu.pe.modelo.Producto;
import vallegrande.edu.pe.modelo.Cliente; // Necesitas crear este
import vallegrande.edu.pe.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoController implements ActionListener {

    private ProductoDAO daoProd;
    private ClienteDAO daoCli; // DAO para Clientes
    private FrmPrincipal vista;

    // Variable para saber en qué pestaña estamos (1: Producto, 2: Cliente, 3: Usuario)
    private int moduloActual = 1;

    public ProductoController(FrmPrincipal v) {
        this.vista = v;
        this.daoProd = new ProductoDAO();
        this.daoCli = new ClienteDAO(); // Inicializar

        // Escuchar TODOS los botones del menú
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnProductos.addActionListener(this);
        this.vista.btnClientes.addActionListener(this);
        this.vista.btnUsuarios.addActionListener(this);

        listarProductos(); // Por defecto inicia en productos
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // --- CAMBIO DE MÓDULOS ---
        if (e.getSource() == vista.btnProductos) {
            moduloActual = 1;
            actualizarLabels("Nombre:", "Precio:", "Stock:");
            listarProductos();
        }
        if (e.getSource() == vista.btnClientes) {
            moduloActual = 2;
            actualizarLabels("Nombre:", "DNI:", "Teléfono:");
            listarClientes();
        }

        // --- BOTÓN GUARDAR (Depende del módulo) ---
        if (e.getSource() == vista.btnGuardar) {
            if (moduloActual == 1) agregarProducto();
            if (moduloActual == 2) agregarCliente();
        }
    }

    // Método para cambiar los textos de la interfaz rápido
    private void actualizarLabels(String l1, String l2, String l3) {
        // Nota: Tendrías que ponerles nombres a tus JLabels en FrmPrincipal
        // O simplemente limpiar los JTextFields
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
    }

    // --- LÓGICA DE PRODUCTOS (Ya la tienes) ---
    public void listarProductos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setColumnCount(0); // Reinicia columnas
        modelo.addColumn("ID"); modelo.addColumn("PRODUCTO"); modelo.addColumn("PRECIO"); modelo.addColumn("STOCK");
        modelo.setRowCount(0);
        List<Producto> lista = daoProd.listar();
        for (Producto p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getStock()});
        }
    }

    public void agregarProducto() {
        try {
            Producto p = new Producto();
            p.setNombre(vista.txtNombre.getText());
            p.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            p.setStock(Integer.parseInt(vista.txtStock.getText()));
            daoProd.agregar(p);
            listarProductos();
            JOptionPane.showMessageDialog(vista, "Producto Guardado");
        } catch (Exception e) { JOptionPane.showMessageDialog(vista, "Datos inválidos"); }
    }

    // --- LÓGICA DE CLIENTES (Estructura espejo) ---
    public void listarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setColumnCount(0);
        modelo.addColumn("ID"); modelo.addColumn("CLIENTE"); modelo.addColumn("DNI"); modelo.addColumn("TELÉFONO");
        modelo.setRowCount(0);
        List<Cliente> lista = daoCli.listar();
        for (Cliente c : lista) {
            modelo.addRow(new Object[]{c.getId(), c.getNombre(), c.getDni(), c.getTelefono()});
        }
    }

    public void agregarCliente() {
        // Similar al de producto pero usando Cliente y daoCli
    }
}