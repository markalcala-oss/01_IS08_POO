package vallegrande.edu.pe.mark_alcala.view;

import javax.swing.*;
import java.awt.*;

public class CalculadoraView extends JFrame {
    public JTextField txtNumeroUno = new JTextField(10);
    public JTextField txtNumeroDos = new JTextField(10);
    public JButton btnSumar = new JButton("Sumar");
    public JLabel lblRes = new JLabel("Resultado: ");

    public CalculadoraView() {
        setTitle("Tarea POO");
        setLayout(new FlowLayout());
        setSize(400, 500);
        add(new JLabel("Numero 1:")); add(txtNumeroUno);
        add(new JLabel("Numero 2:")); add(txtNumeroDos);
        add(btnSumar); add(lblRes);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}