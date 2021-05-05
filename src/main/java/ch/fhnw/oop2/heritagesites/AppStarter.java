package ch.fhnw.oop2.heritagesites;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import ch.fhnw.oop2.heritagesites.views.BorderUI;
import ch.fhnw.oop2.heritagesites.views.SplitUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        // todo evtl. sogar andere form (z.b borderpane) wählen für header, footer

        Parent rootPanel = new BorderUI(model);

        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        rootPanel.getStylesheets().add(path);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(model.applicationTitleProperty());

        primaryStage.setScene(scene);
        primaryStage.show();








    }




}
