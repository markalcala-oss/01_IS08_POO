package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Plato;
import vallegrande.edu.pe.model.PlatoDAO;

public class PlatoController {
    private PlatoDAO dao = new PlatoDAO();

    public void agregarPlato(String nombre, double precio, String categoria) {
        Plato nuevoPlato = new Plato(0, nombre, precio, categoria);
        if (dao.registrar(nuevoPlato)) {
            System.out.println("¡Plato guardado exitosamente en la nube!");
        } else {
            System.out.println("Error al intentar guardar el plato.");
        }
    }
}
