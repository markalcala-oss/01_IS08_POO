package vallegrande.edu.pe.controlador;

import vallegrande.edu.pe.dao.ProductoDAO;
import vallegrande.edu.pe.modelo.Producto;
import vallegrande.edu.pe.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProductoController implements ActionListener {

    private ProductoDAO dao;
    private Producto p;
    private FrmPrincipal vista;

    public ProductoController(FrmPrincipal v) {
        this.vista = v;
        this.dao = new ProductoDAO();
        this.p = new Producto();
        // Aquí escuchamos el botón de tu formulario
        this.vista.btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            agregar();
        }
    }

    public void agregar() {
        // 1. Validaciones (Requisito del documento)
        if(vista.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El nombre es obligatorio");
            return;
        }

        // 2. Seteamos los datos desde la vista al modelo
        p.setNombre(vista.txtNombre.getText());
        p.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
        p.setStock(Integer.parseInt(vista.txtStock.getText()));

        // 3. Llamamos al DAO
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "¡Producto Agregado con Éxito!");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar");
        }
    }
}