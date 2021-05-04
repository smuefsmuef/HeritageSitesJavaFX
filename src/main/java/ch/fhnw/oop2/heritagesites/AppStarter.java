package ch.fhnw.oop2.heritagesites;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import ch.fhnw.oop2.heritagesites.views.UnitedUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppStarter extends Application {

    // hierarchie bsp-
    // stage = rahmen oben
    // parent
    // region
    // scene
    // pane (stack pane)
    // buttpns

    @Override
    public void start(Stage primaryStage) throws Exception {

        PM model = new PM();

        // Splitpane --> als start
        Parent rootPanel = new UnitedUI(model);

        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        rootPanel.getStylesheets().add(path);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(model.applicationTitleProperty());

        primaryStage.setScene(scene);
        primaryStage.show();








    }




}
