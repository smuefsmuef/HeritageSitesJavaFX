package ch.fhnw.oop2.heritagesites;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import ch.fhnw.oop2.heritagesites.views.BorderUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        PM model = new PM();

        // gerüst Borderpane, darin splitpane und dann je nach seite unterschiedlich
        Parent rootPanel = new BorderUI(model);

        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        rootPanel.getStylesheets().add(path);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(model.applicationTitleProperty());

        primaryStage.setWidth(800);
        primaryStage.setHeight(500);

        primaryStage.setScene(scene);
        primaryStage.show();








    }




}
