module iespoblenou.arc.dnigenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens iespoblenou.arc.dnigenerator to javafx.fxml;
    exports iespoblenou.arc.dnigenerator;
    exports iespoblenou.arc.dnigenerator.form_component;
    opens iespoblenou.arc.dnigenerator.form_component to javafx.fxml;
}