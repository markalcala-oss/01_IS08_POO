package vallegrande.edu.pe;

import javax.swing.*; // Importa las herramientas de Swing
import java.awt.*;    // Importa herramientas de diseño

public class prueba {
    public static void main(String[] args) {// 1. JFrame (La ventana)
        JFrame frame = new JFrame("Mi Ejemplo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// 2. JPanel (El contenedor)
        JPanel panel = new JPanel();
        frame.add(panel);

// 3. JLabel, JTextField y JCheckBox
        panel.add(new JLabel("Nombre:"));
        panel.add(new JTextField(15));
        panel.add(new JCheckBox("¿Aceptar?"));

// 4. Mostrar todo
        frame.setVisible(true);

// 5. JOptionPane (Aparece al iniciar)
        JOptionPane.showMessageDialog(frame, "¡Bienvenido a IntelliJ!");
    }
}
