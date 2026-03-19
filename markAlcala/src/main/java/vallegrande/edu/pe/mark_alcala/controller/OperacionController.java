package vallegrande.edu.pe.mark_alcala.controller;

import vallegrande.edu.pe.mark_alcala.model.Operacion;
import vallegrande.edu.pe.mark_alcala.view.CalculadoraView;

public class OperacionController {
    public void iniciar() {
        CalculadoraView vista = new CalculadoraView();
        vista.setVisible(true);
        vista.btnSumar.addActionListener(e -> {
            double v1 = Double.parseDouble(vista.txtNumeroUno.getText());
            double v2 = Double.parseDouble(vista.txtNumeroDos.getText());

            // AQUÍ SE CREA EL OBJETO CON DATOS (Actividad 1)
            Operacion op = new Operacion(v1, v2);
            vista.lblRes.setText("Resultado: " + op.sumar());
        });
    }
}