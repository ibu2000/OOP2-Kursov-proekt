package bg.tu_varna.sit.library.application;

import bg.tu_varna.sit.library.common.Constants;
import eu.hansolo.tilesfx.Section;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private static Logger log = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path = getClass().getResource(Constants.View.SAMPLE);

        if(path !=null)
        {
           Parent root =FXMLLoader.load(path);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

           stage.setTitle(Constants.Values.Title);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setMaxWidth(1780);
            stage.setMaxHeight(1630);
            stage.setWidth(1320);
            stage.setHeight(940);
            stage.show();
        }
        else
        {
            log.error("Sorry, the main fxml could not be loaded");
            System.exit(-1);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}