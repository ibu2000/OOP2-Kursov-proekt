package bg.tu_varna.sit.library.application;

import bg.tu_varna.sit.library.common.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Logger log = Logger.getLogger(HelloApplication.class);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(Constants.View.HELLO_VIEW));
         Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        PropertyConfigurator.configure(HelloApplication.class.getResource());

    }


    public static void main(String[] args) {
        launch();
    }
}