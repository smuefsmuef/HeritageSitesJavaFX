package ch.fhnw.oop2.heritagesites;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Marcel Gygli
 */
public class DemoClass extends Application {

    public DemoClass() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent node = new GridPane();
        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        node.getStylesheets().add(path);
        Scene scene = new Scene(node);
        stage.setScene(scene);
        stage.show();
    }

    public String helloWorld() {
        return "Hello World";
    }
}
