package vallegrande.edu.pe.controlador;

import vallegrande.edu.pe.dao.ProductoDAO;
import vallegrande.edu.pe.modelo.Producto;
import vallegrande.edu.pe.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; // IMPORTANTE: Agrega esto
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; // IMPORTANTE: Agrega esto

public class ProductoController implements ActionListener {

    private ProductoDAO dao;
    private Producto p;
    private FrmPrincipal vista;

    public ProductoController(FrmPrincipal v) {
        this.vista = v;
        this.dao = new ProductoDAO();
        this.p = new Producto();
        this.vista.btnGuardar.addActionListener(this);

        // --- AGREGADO: Cargar la tabla apenas abra el programa ---
        listar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            agregar();
        }
    }

    // --- AGREGADO: Método para llenar la tabla ---
    public void listar() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0); // Limpiar tabla
        List<Producto> lista = dao.listar(); // Llama al método listar de tu DAO
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getPrecio();
            objeto[3] = lista.get(i).getStock();
            modelo.addRow(objeto);
        }
    }

    public void agregar() {
        try { // Agregamos try-catch para que no "explote" con el error de antes
            if(vista.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El nombre es obligatorio");
                return;
            }

            p.setNombre(vista.txtNombre.getText());
            p.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            p.setStock(Integer.parseInt(vista.txtStock.getText()));

            int r = dao.agregar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "¡Producto Agregado con Éxito!");
                listar(); // --- AGREGADO: Refresca la tabla después de guardar ---
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: Revisa que precio y stock sean números");
        }
    }
}