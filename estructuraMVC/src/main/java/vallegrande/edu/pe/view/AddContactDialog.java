package vallegrande.edu.pe.view;


import vallegrande.edu.pe.controller.ContactController;


import javax.swing.*;
import java.awt.*;
import java.util.UUID;


/**
 * Diálogo modal para agregar un nuevo contacto.
 */
public class AddContactDialog extends JDialog {
    private final JTextField nameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JTextField phoneField = new JTextField(20);
    private final JTextField direccionField = new JTextField(20);
    private final JTextField empresaField = new JTextField(20);
    private final JTextField ciudadField = new JTextField(20);
    private final JTextField paisField = new JTextField(20);

    private final ContactController controller;
    private boolean succeeded;


    public AddContactDialog(Frame parent, ContactController controller) {
        super(parent, "Agregar Contacto", true);
        this.controller = controller;
        initUI();
    }


    // Inicializar componentes UI
    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Nombre:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Teléfono:"));
        panel.add(phoneField);
        panel.add(new JLabel("direccion:"));
        panel.add(direccionField);
        panel.add (new JLabel("empresa:"));
        panel.add(empresaField);
        panel.add(new JLabel("ciudad:"));
        panel.add(ciudadField);
        panel.add(new JLabel("pais"));
        panel.add(paisField);

        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancelar");


        okBtn.addActionListener(e -> onOK());
        cancelBtn.addActionListener(e -> onCancel());


        JPanel btnPanel = new JPanel();
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);


        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(getParent());
    }


    // Acción al presionar OK
    private void onOK() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String direccion = direccionField.getText().trim();
        String empresa = empresaField.getText().trim();
        String ciudad = ciudadField.getText().trim();
        String pais = paisField.getText().trim();


        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Crear contacto con ID único generado
        controller.create(UUID.randomUUID().toString(), name, email, phone,direccion,empresa,ciudad,pais);
        succeeded = true;
        dispose();
    }


    // Acción al presionar Cancelar
    private void onCancel() {
        succeeded = false;
        dispose();
    }


    public boolean isSucceeded() {
        return succeeded;
    }
}