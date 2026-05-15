package vallegrande.edu.pe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        vallegrande.edu.pe.controller.PlatoController control = new vallegrande.edu.pe.controller.PlatoController();

        // Probando registrar un plato
        control.agregarPlato("Ceviche Clásico", 35.50, "Entradas");
    }

}