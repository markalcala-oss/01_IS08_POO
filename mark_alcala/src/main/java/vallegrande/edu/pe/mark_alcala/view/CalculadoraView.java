package vallegrande.edu.pe.mark_alcala.view;

import javax.swing.*;
import java.awt.*;

public class CalculadoraView extends JFrame {
    // Componentes que usaremos
    public JTextField txtN1 = new JTextField(10);
    public JTextField txtN2 = new JTextField(10);
    public JButton btnSumar = new JButton("Sumar");
    public JLabel lblResultado = new JLabel("Resultado: ");

    public CalculadoraView() {
        // Configuración básica de la ventana
        setTitle("Calculadora POO");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Organiza los elementos uno tras otro

        // Agregamos los elementos a la pantalla
        add(new JLabel("Número 1:"));
        add(txtN1);
        add(new JLabel("Número 2:"));
        add(txtN2);
        add(btnSumar);
        add(lblResultado);

        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }
}
