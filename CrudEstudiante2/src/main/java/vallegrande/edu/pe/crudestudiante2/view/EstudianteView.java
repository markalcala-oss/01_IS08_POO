package vallegrande.edu.pe.crudestudiante2.view;

import vallegrande.edu.pe.crudestudiante2.controller.EstudianteController;
import vallegrande.edu.pe.crudestudiante2.model.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EstudianteView extends JFrame {
    private JTextField txtNombre, txtEdad, txtCarrera;
    private JTable table;
    private DefaultTableModel model;

    EstudianteController controller = new EstudianteController();

    public EstudianteView() {
        setTitle("Registro de Estudiantes");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(230,240,255));
        JPanel formulario = new JPanel();
        formulario.setBackground(new Color(200 ,220,255));

        formulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(10);
        formulario.add(txtNombre);

        formulario.add(new JLabel("Edad:"));
        txtEdad = new JTextField(5);
        formulario.add(txtEdad);

        formulario.add(new JLabel("Carrera:"));
        txtCarrera = new JTextField(5);
        formulario.add(txtCarrera);

        JButton btnIngresar = new JButton("Ingresar");
        formulario.add(btnIngresar);

        panel.add(formulario, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Carrera");

        table = new JTable(model);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        btnIngresar.addActionListener(e -> agregarEstudiante());
        add(panel, BorderLayout.NORTH);
    }

    private void agregarEstudiante(){
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String carrera = txtCarrera.getText();

        controller.agregarEstudiante(nombre, edad, carrera);
        model.setRowCount(0);

        for(Estudiante es: controller.listar()) {
            model.addRow(new Object[]{
                    es.getNombre(),
                    es.getEdad(),
                    es.getCarrera()
            });
        }
            txtNombre.setText("");
            txtEdad.setText("");
            txtCarrera.setText("");
        }
        public static void main ( String [] args ){
            new EstudianteView().setVisible(true);
        }
    }

