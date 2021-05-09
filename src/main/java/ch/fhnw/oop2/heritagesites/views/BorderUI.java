package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


// borderUI contains top, center and bottom
// top: to do here
// center --> SplitPane SplitUI
// bottom : to do here (advanced feature)

public class BorderUI extends BorderPane {
    private final PM model;
    private SplitUI split;
    private HBox top;
    private HBox bottom;

    private Button bottomButton;
    private Button addNewButton = new Button("+");
    private Button deleteButton = new Button("-");
    private Button saveButton = new Button("Save");

    public BorderUI(PM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
        setupEventHandlers();
    }

    private void initializeControls() {
        split = new SplitUI(model);
        top = addHBoxTop();
        bottom = addHBoxBottom();
    }

    private void layoutControls() {
        setTop(top);
        setCenter(split);
        setBottom(bottom);
    }

    public HBox addHBoxTop() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15));
        hbox.setSpacing(10);

        hbox.setId("top");

        addNewButton.setPrefSize(20, 20);
        addNewButton.setId("addNewButton");

        deleteButton.setPrefSize(20, 20);
        deleteButton.setId("deleteButton");

        saveButton.setPrefSize(100, 20);
        saveButton.setId("saveButton");

        hbox.getChildren().addAll(addNewButton, deleteButton, saveButton);

        return hbox;
    }

    public HBox addHBoxBottom() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15));
        hbox.setSpacing(10);

        hbox.setId("bottom");

        bottomButton = new Button("bottom, counter, visited heritages, visited countries");
        bottomButton.setMaxWidth(Double.MAX_VALUE);

        setMargin(bottomButton, new Insets(15));
        hbox.getChildren().addAll(bottomButton);

        return hbox;
    }


    private void setupBindings() {

        // model.addSite();
        // model.deleteSite();

        // todo: with new form on the left
        addNewButton.setOnMouseClicked(event -> System.out.println(event));

        // todo: remove the clicked one, bind klicked list element
        deleteButton.setOnMouseClicked(event -> model.getAllSites().remove(0));

        // todo: setup save
        saveButton.setOnMouseClicked(event -> model.save());

    }

    private void setupEventHandlers() {

    }

}