module vallegrande.edu.pe.prueba {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens vallegrande.edu.pe.prueba to javafx.fxml;
    exports vallegrande.edu.pe.prueba;
}