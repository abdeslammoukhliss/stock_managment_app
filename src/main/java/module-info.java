module org.example.stock_management_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires hibernate.entitymanager;
    requires org.hibernate.orm.core;
    requires java.sql;

    requires static lombok;
    opens org.example.stock_management_app.entities to org.hibernate.orm.core;
    opens org.example.stock_management_app.repositories to org.hibernate.orm.core;
    opens org.example.stock_management_app to javafx.fxml;
    exports org.example.stock_management_app;
}