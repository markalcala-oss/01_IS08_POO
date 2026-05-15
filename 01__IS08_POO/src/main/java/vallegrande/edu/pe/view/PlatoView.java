package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.PlatoController;
import javax.swing.*;
import java.awt.*;

public class PlatoView extends JFrame {
    private JTextField txtNombre, txtPrecio, txtCategoria;
    private JButton btnGuardar;
    private PlatoController controller;

    public PlatoView() {
        controller = new PlatoController();
        setTitle("Registro de Platos - Restaurante");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridLayout(5, 2, 10, 10));

        // Campos del formulario
        add(new JLabel("  Nombre del Plato:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("  Precio (S/):"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("  Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        add(new JLabel("")); // Espacio vacío
        btnGuardar = new JButton("Guardar en la Nube");
        btnGuardar.setBackground(new Color(0, 150, 0));
        btnGuardar.setForeground(Color.WHITE);
        add(btnGuardar);

        // Evento del botón
        btnGuardar.addActionListener(e -> {
            try {
                String nom = txtNombre.getText();
                double pre = Double.parseDouble(txtPrecio.getText());
                String cat = txtCategoria.getText();

                controller.agregarPlato(nom, pre, cat);
                JOptionPane.showMessageDialog(this, "¡Plato guardado correctamente!");

                // Limpiar campos
                txtNombre.setText("");
                txtPrecio.setText("");
                txtCategoria.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: El precio debe ser un número.");
            }
        });

        setVisible(true);
    }
}