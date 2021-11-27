module teodora_trifonova_ivelin_belinov.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens teodora_trifonova_ivelin_belinov.library to javafx.fxml;
    exports teodora_trifonova_ivelin_belinov.library;
    exports teodora_trifonova_ivelin_belinov.library.application;
    opens teodora_trifonova_ivelin_belinov.library.application to javafx.fxml;
    exports teodora_trifonova_ivelin_belinov.library.presentation;
    opens teodora_trifonova_ivelin_belinov.library.presentation to javafx.fxml;
    exports teodora_trifonova_ivelin_belinov.library.presentation.controllers;
    opens teodora_trifonova_ivelin_belinov.library.presentation.controllers to javafx.fxml;
}