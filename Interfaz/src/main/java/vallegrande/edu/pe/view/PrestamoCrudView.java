package vallegrande.edu.pe.view;


import vallegrande.edu.pe.controller.PrestamoController;
import vallegrande.edu.pe.model.Prestamo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrestamoCrudView extends JFrame {

    private PrestamoController controller = new PrestamoController();
    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField txtLibro, txtUsuario, txtFecha;

    public PrestamoCrudView() {
        setTitle("Gestión de Préstamos");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔵 HEADER
        JPanel header = new JPanel();
        header.setBackground(new Color(21, 67, 96));
        JLabel titulo = new JLabel("📖 Gestión de Préstamos");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        header.add(titulo);
        add(header, BorderLayout.NORTH);

        // ⚪ FORMULARIO
        JPanel form = new JPanel(new GridLayout(2,3,10,10));
        form.setBorder(BorderFactory.createTitledBorder("Datos del Préstamo"));
        form.setBackground(Color.WHITE);

        txtLibro = new JTextField();
        txtUsuario = new JTextField();
        txtFecha = new JTextField();

        form.add(new JLabel("Libro:"));
        form.add(new JLabel("Usuario:"));
        form.add(new JLabel("Fecha:"));

        form.add(txtLibro);
        form.add(txtUsuario);
        form.add(txtFecha);

        add(form, BorderLayout.BEFORE_FIRST_LINE);

        // 📋 TABLA
        modelo = new DefaultTableModel(new String[]{"Libro","Usuario","Fecha"},0);
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // 🔘 BOTONES
        JPanel botones = new JPanel();
        botones.setBackground(Color.WHITE);

        JButton btnAgregar = new JButton("➕ Agregar");
        JButton btnEliminar = new JButton("🗑️ Eliminar");
        JButton btnVolver = new JButton("⬅ Menú");

        btnAgregar.setBackground(new Color(40, 116, 166));
        btnAgregar.setForeground(Color.WHITE);

        btnEliminar.setBackground(new Color(192, 57, 43));
        btnEliminar.setForeground(Color.WHITE);

        botones.add(btnAgregar);
        botones.add(btnEliminar);
        botones.add(btnVolver);

        add(botones, BorderLayout.SOUTH);

        // EVENTOS
        btnVolver.addActionListener(e -> {
            new MiniPaginaView().setVisible(true);
            dispose();
        });

        btnAgregar.addActionListener(e -> {
            if(validar()){
                controller.agregar(
                        txtLibro.getText(),
                        txtUsuario.getText(),
                        txtFecha.getText()
                );
                limpiar();
                cargarTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila >= 0){
                controller.eliminar(fila);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un registro");
            }
        });
    }

    private boolean validar(){
        if(txtLibro.getText().isEmpty() ||
                txtUsuario.getText().isEmpty() ||
                txtFecha.getText().isEmpty()){

            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return false;
        }
        return true;
    }

    private void limpiar(){
        txtLibro.setText("");
        txtUsuario.setText("");
        txtFecha.setText("");
    }

    private void cargarTabla(){
        modelo.setRowCount(0);
        for(Prestamo p : controller.listar()){
            modelo.addRow(new Object[]{
                    p.getLibro(),
                    p.getUsuario(),
                    p.getFecha()
            });
        }
    }
}
