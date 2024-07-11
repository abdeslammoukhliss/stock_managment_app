module org.example.stock_management_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.stock_management_app to javafx.fxml;
    exports org.example.stock_management_app;
}