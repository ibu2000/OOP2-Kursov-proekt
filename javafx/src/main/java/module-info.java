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
}