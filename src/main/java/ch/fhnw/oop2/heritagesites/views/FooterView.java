package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FooterView extends HBox {

    private final PM model;
   
    private Button bottomButton;
private Label totalEntries;
private Label visitedCountries;

    public FooterView(PM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
        setupEventHandlers();
    }

    private void initializeControls() {
      
    }

    private void layoutControls() {
        setPadding(new Insets(5));
        setSpacing(10);

        setId("bottom");

        totalEntries = new Label("/ " + model.getTotalCountries());
        visitedCountries = new Label("" + model.getTotalCountries());


        bottomButton = new Button("bottom, counter, visited heritages, visited countries");
        bottomButton.setMaxWidth(Double.MAX_VALUE);

        setMargin(bottomButton, new Insets(5));
        getChildren().addAll(bottomButton, visitedCountries, totalEntries);
    }



    private void setupEventHandlers() {

    }


    private void setupBindings() {


    }

}
