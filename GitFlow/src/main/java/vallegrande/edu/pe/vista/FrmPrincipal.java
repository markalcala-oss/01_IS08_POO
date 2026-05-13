package vallegrande.edu.pe.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    // 1. LAS VARIABLES DEBEN SER PÚBLICAS Y ESTAR AQUÍ AFUERA
    public JButton btnProductos, btnClientes, btnUsuarios, btnSalir, btnGuardar;
    public JTextField txtNombre, txtPrecio, txtStock;
    public JTable tabla; // <--- ESTA ES LA QUE DA EL ERROR
    public DefaultTableModel modelo;

    public FrmPrincipal() {
        // Configuración básica
        setTitle("Sistema Integrado - Valle Grande S12");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 150, 243));
        panelHeader.setPreferredSize(new Dimension(0, 80));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN ACADÉMICA");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        panelHeader.add(lblTitulo);

        // Menú Lateral
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(45, 45, 45));
        panelMenu.setPreferredSize(new Dimension(220, 0));
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        btnProductos = crearBotonMenu("Gestionar Productos");
        btnClientes = crearBotonMenu("Gestionar Clientes");
        btnUsuarios = crearBotonMenu("Gestionar Usuarios");
        btnGuardar = crearBotonMenu("Guardar");
        btnGuardar.setBackground(new Color(76, 175, 80));
        btnGuardar.setForeground(Color.WHITE);

        btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBackground(new Color(255, 82, 82));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setPreferredSize(new Dimension(180, 40));

        panelMenu.add(btnProductos);
        panelMenu.add(btnClientes);
        panelMenu.add(btnUsuarios);
        panelMenu.add(btnSalir);

        // Panel Central
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Color.WHITE);

        // Inputs
        JPanel panelInputs = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 20));
        panelInputs.setBackground(Color.WHITE);
        txtNombre = new JTextField(12);
        txtPrecio = new JTextField(8);
        txtStock = new JTextField(8);

        panelInputs.add(new JLabel("Nombre:")); panelInputs.add(txtNombre);
        panelInputs.add(new JLabel("Precio:")); panelInputs.add(txtPrecio);
        panelInputs.add(new JLabel("Stock:")); panelInputs.add(txtStock);
        panelInputs.add(btnGuardar);

        // --- INICIALIZACIÓN DE LA TABLA ---
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");

        tabla = new JTable(modelo); // Aquí se crea el objeto
        JScrollPane scrollTabla = new JScrollPane(tabla);
        // ----------------------------------

        panelCentro.add(panelInputs, BorderLayout.NORTH);
        panelCentro.add(scrollTabla, BorderLayout.CENTER);

        add(panelHeader, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        add(panelCentro, BorderLayout.CENTER);
    }

    public JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(180, 40));
        boton.setFocusable(false);
        return boton;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        SwingUtilities.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }
}