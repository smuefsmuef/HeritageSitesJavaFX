package ch.fhnw.oop2.heritagesites;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import ch.fhnw.oop2.heritagesites.views.ApplicationUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        WorldHeritagesPM model = new WorldHeritagesPM();

        Parent rootPanel = new ApplicationUI(model);

        // instead of initialize the css file in each UI View, i do it once right here
        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        rootPanel.getStylesheets().add(path);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(model.applicationTitleProperty());

        primaryStage.setWidth(1100); // just for startup
        primaryStage.setHeight(600);

        primaryStage.setScene(scene);
        primaryStage.show();


    }


}
