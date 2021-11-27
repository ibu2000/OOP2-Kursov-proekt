module bg.tu_varna.sit.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens bg.tu_varna.sit.library to javafx.fxml;
    exports bg.tu_varna.sit.library;
    exports bg.tu_varna.sit.library.application;
    opens bg.tu_varna.sit.library.application to javafx.fxml;
    exports bg.tu_varna.sit.library.presentation;
    opens bg.tu_varna.sit.library.presentation to javafx.fxml;
    exports bg.tu_varna.sit.library.presentation.controllers;
    opens bg.tu_varna.sit.library.presentation.controllers to javafx.fxml;
}