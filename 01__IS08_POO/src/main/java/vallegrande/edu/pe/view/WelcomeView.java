package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class WelcomeView extends JFrame {

    public WelcomeView() {
        setTitle("Sistema Gastronómico - Bienvenido");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new BorderLayout());

        // Panel Principal con fondo oscuro/elegante
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Color(28, 35, 49));
        panelCentral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        // Título Principal
        JLabel lblTitulo = new JLabel("BIENVENIDO AL SISTEMA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridy = 0;
        panelCentral.add(lblTitulo, gbc);

        // Subtítulo / Descripción
        JLabel lblSub = new JLabel("Módulo de Gestión de Platos (MVC)");
        lblSub.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSub.setForeground(new Color(170, 185, 205));
        gbc.gridy = 1;
        panelCentral.add(lblSub, gbc);

        // Botón de Ingreso
        JButton btnIngresar = new JButton("Ingresar al Sistema");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(76, 175, 80)); // Verde bonito
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 2;
        gbc.insets = new Insets(25, 10, 10, 10);
        panelCentral.add(btnIngresar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Evento del botón para cambiar de ventana
        btnIngresar.addActionListener(e -> {
            // Abrimos la ventana del CRUD que ya funciona
            new PlatoView();
            // Cerramos esta ventana de bienvenida
            this.dispose();
        });

        setVisible(true);
    }
}