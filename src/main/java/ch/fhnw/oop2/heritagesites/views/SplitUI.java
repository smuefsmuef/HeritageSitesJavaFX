package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SplitUI extends SplitPane {
    private final PM model;

     private Label test;

    public SplitUI(PM model) {
        this.model = model;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        // css file in app starter, will be universal for all UI
    }

    public void initializeControls() {
        test = new Label("sdfsdfssd");
    }

    private void layoutControls() {
        // todo:

        // links --> über neues UI lösen
        GridPane leftControl = new GridPane();


        // rechts --> über neues UI lösen
        VBox rightControl = new VBox(new Label("Right Control"));
        getItems().addAll(leftControl, rightControl);

        getChildren().addAll(test);

    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
    }


}
