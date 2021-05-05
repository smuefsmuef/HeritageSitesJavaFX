package ch.fhnw.oop2.heritagesites.views;


import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FormApplicationUI extends VBox {
    private final PM model;
    private Label test;


    Text title = new Text("Data");


    Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Sales"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")};

// todo check if there is some form template


    public FormApplicationUI(PM model) {
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
        test   = new Label("rechte seite");

    }



    private void layoutControls() {
        setMargin(test, new Insets(5));

        setPadding(new Insets(10));
        setSpacing(8);

        getChildren().addAll(test, title);

        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            getChildren().add(options[i]);
        }


    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
    }



}
