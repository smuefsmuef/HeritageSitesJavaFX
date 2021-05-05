package ch.fhnw.oop2.heritagesites.views;


import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ListApplicationUI extends VBox {
    private final PM model;
    private Button button;


   //  todo: create a table


    public ListApplicationUI(PM model) {
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
        button   = new Button("left side");

    }



    private void layoutControls() {
        //button.setMaxWidth(Double.MAX_VALUE);
        getChildren().addAll(button);
        setMargin(button, new Insets(5));



    }

    private void setupEventHandlers() {
       // button.setOnAction(event -> model.addNewElement());
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
    }


}
