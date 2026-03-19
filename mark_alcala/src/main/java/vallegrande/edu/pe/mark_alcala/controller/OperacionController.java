package vallegrande.edu.pe.mark_alcala.controller;

import vallegrande.edu.pe.mark_alcala.model.Operacion;
import vallegrande.edu.pe.mark_alcala.view.CalculadoraView;

public class OperacionController {

    public void iniciar() {
        CalculadoraView vista = new CalculadoraView();
        vista.setVisible(true);

        // Programamos el botón
        vista.btnSumar.addActionListener(e -> {
            try {
                // Sacamos los números de los cuadros de texto
                double n1 = Double.parseDouble(vista.txtN1.getText());
                double n2 = Double.parseDouble(vista.txtN2.getText());

                // CREAMOS EL OBJETO (Actividad de la guía)
                Operacion op = new Operacion(n1, n2);

                // Mostramos el resultado
                vista.lblResultado.setText("Resultado: " + op.sumar());
            } catch (NumberFormatException ex) {
                vista.lblResultado.setText("Error: Ingresa números");
            }
        });
    }
}