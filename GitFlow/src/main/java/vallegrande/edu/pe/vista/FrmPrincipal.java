package vallegrande.edu.pe.vista;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    // --- AQUÍ ESTÁ EL TRUCO: Declararlos como PUBLIC y fuera del constructor ---
    public JButton btnProductos, btnClientes, btnUsuarios, btnSalir, btnGuardar;
    public JTextField txtNombre, txtPrecio, txtStock;
    // --------------------------------------------------------------------------

    public FrmPrincipal() {
        // 1. Configuración básica
        setTitle("Sistema Integrado - Valle Grande S12");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 2. Panel Superior
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 150, 243));
        panelHeader.setPreferredSize(new Dimension(0, 80));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN ACADÉMICA");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        panelHeader.add(lblTitulo);

        // 3. Panel Lateral
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(45, 45, 45));
        panelMenu.setPreferredSize(new Dimension(220, 0));
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Inicializamos los botones que declaramos arriba
        btnProductos = crearBotonMenu("Gestionar Productos");
        btnClientes = crearBotonMenu("Gestionar Clientes");
        btnUsuarios = crearBotonMenu("Gestionar Usuarios");
        btnGuardar = crearBotonMenu("Guardar"); // Lo necesitamos para el CRUD

        btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBackground(new Color(255, 82, 82));
        btnSalir.setForeground(Color.WHITE);

        panelMenu.add(btnProductos);
        panelMenu.add(btnClientes);
        panelMenu.add(btnUsuarios);
        panelMenu.add(btnSalir);

        // 4. Panel Central (Inputs para el CRUD)
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.white);
        panelCentro.setLayout(new FlowLayout());

        // Inicializamos los textos para que el controlador no de error
        txtNombre = new JTextField(15);
        txtPrecio = new JTextField(10);
        txtStock = new JTextField(10);

        panelCentro.add(new JLabel("Nombre:")); panelCentro.add(txtNombre);
        panelCentro.add(new JLabel("Precio:")); panelCentro.add(txtPrecio);
        panelCentro.add(new JLabel("Stock:")); panelCentro.add(txtStock);
        panelCentro.add(btnGuardar);

        // 5. Agregar paneles
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }
}