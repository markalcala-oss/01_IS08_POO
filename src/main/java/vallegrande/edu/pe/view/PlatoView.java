package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.PlatoController;
import vallegrande.edu.pe.model.Plato;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PlatoView extends JFrame {
    private JTextField txtNombre, txtPrecio, txtCategoria;
    private JButton btnGuardar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private PlatoController controller;

    public PlatoView() {
        controller = new PlatoController();
        setTitle("Mantenimiento de Platos - MVC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // PANEL SUPERIOR: Formulario
        JPanel pnlForm = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlForm.setBorder(BorderFactory.createTitledBorder("Datos del Plato"));

        pnlForm.add(new JLabel(" Nombre:"));
        txtNombre = new JTextField();
        pnlForm.add(txtNombre);

        pnlForm.add(new JLabel(" Precio:"));
        txtPrecio = new JTextField();
        pnlForm.add(txtPrecio);

        pnlForm.add(new JLabel(" Categoría:"));
        txtCategoria = new JTextField();
        pnlForm.add(txtCategoria);

        btnGuardar = new JButton("Guardar Plato");
        btnGuardar.setBackground(new Color(33, 150, 243));
        btnGuardar.setForeground(Color.WHITE);
        pnlForm.add(new JLabel("")); // Espacio
        pnlForm.add(btnGuardar);

        add(pnlForm, BorderLayout.NORTH);

        // PANEL CENTRAL: Tabla
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Categoría"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // EVENTOS
        btnGuardar.addActionListener(e -> guardar());

        // Cargar datos al abrir
        listar();

        setVisible(true);
    }

    private void guardar() {
        try {
            String nom = txtNombre.getText();
            double pre = Double.parseDouble(txtPrecio.getText());
            String cat = txtCategoria.getText();
            controller.agregarPlato(nom, pre, cat);
            listar(); // Recargar tabla
            limpiar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos");
        }
    }

    private void listar() {
        modelo.setRowCount(0); // Limpiar tabla
        List<Plato> lista = controller.listarPlatos();
        for (Plato p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getCategoria()});
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCategoria.setText("");
    }
}