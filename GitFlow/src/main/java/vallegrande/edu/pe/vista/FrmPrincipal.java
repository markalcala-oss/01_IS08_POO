package vallegrande.edu.pe.vista;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    public FrmPrincipal() {
        // 1. Configuración básica de la ventana
        setTitle("Sistema Integrado - Valle Grande S12");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout());

        // 2. Panel Superior (Encabezado) - MEJORA VISUAL
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 150, 243)); // Azul brillante
        panelHeader.setPreferredSize(new Dimension(0, 80));

        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN ACADÉMICA");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        panelHeader.add(lblTitulo);

        // 3. Panel Lateral (Navegación / Menú)
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(45, 45, 45)); // Gris oscuro profesional
        panelMenu.setPreferredSize(new Dimension(220, 0));
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Botones de los Módulos CRUD
        JButton btnProductos = crearBotonMenu("Gestionar Productos");
        JButton btnClientes = crearBotonMenu("Gestionar Clientes");
        JButton btnUsuarios = crearBotonMenu("Gestionar Usuarios");
        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBackground(new Color(255, 82, 82));
        btnSalir.setForeground(Color.WHITE);

        panelMenu.add(btnProductos);
        panelMenu.add(btnClientes);
        panelMenu.add(btnUsuarios);
        panelMenu.add(btnSalir);

        // 4. Panel Central (Área de Trabajo)
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.white);
        panelCentro.setLayout(new GridBagLayout());

        JLabel lblBienvenida = new JLabel("<html><center><h1>Bienvenido al Sistema</h1><p>Seleccione un módulo en la izquierda para trabajar.</p></center></html>");
        panelCentro.add(lblBienvenida);

        // 5. Agregar paneles al JFrame
        add(panelHeader, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        add(panelCentro, BorderLayout.CENTER);
    }

    // Método para crear botones con estilo rápido
    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(180, 40));
        boton.setFocusable(false);
        return boton;
    }

    // El método Main para ejecutar la vista
    public static void main(String[] args) {
        try {
            // Esto hace que se vea como Windows y no como Java viejo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }
}
