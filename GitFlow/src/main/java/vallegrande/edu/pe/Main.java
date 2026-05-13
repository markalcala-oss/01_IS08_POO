package vallegrande.edu.pe;

import vallegrande.edu.pe.vista.FrmPrincipal;
import vallegrande.edu.pe.controlador.ProductoController;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // 1. Ponerle estilo de Windows (Mejora visual requerida)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Iniciar la Vista y el Controlador
        // Esto une las capas del MVC
        FrmPrincipal vista = new FrmPrincipal();
        new ProductoController(vista);

        // 3. Mostrar la ventana
        vista.setVisible(true);
    }
}