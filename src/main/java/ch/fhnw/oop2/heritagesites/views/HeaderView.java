package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HeaderView extends HBox {

    private final WorldHeritagesPM model;

    private Button addNewButton = new Button("Create Site");
    private Button deleteButton = new Button("Remove Site");
    private Button saveButton = new Button("Save");

    private TextField searchBox = new TextField("");

    public HeaderView(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
        setupEventHandlers();
        setupValueChangedListeners();
    }

    private void initializeControls() {

    }

    private void layoutControls() {
        setPadding(new Insets(5, 5, 5, 12));
        setSpacing(5);

        setId("top");

        addNewButton.setPrefSize(100, 15);
        addNewButton.setId("addNewButton");

        deleteButton.setPrefSize(100, 15);
        deleteButton.setId("deleteButton");

        saveButton.setPrefSize(100, 15);
        saveButton.setId("saveButton");

        searchBox.setPrefSize(200, 11);
        searchBox.setId("search-box");

        deleteButton.setDisable(true);
        saveButton.setDisable(true);

        getChildren().addAll(addNewButton, deleteButton, saveButton, searchBox);

    }


    private void setupEventHandlers() {
        // delete site
        deleteButton.setOnAction(event -> model.deleteSite(model.getSelectedHeritageId()));

        // add site
        addNewButton.setOnAction(event -> model.addSite());

        // save current list
        saveButton.setOnAction(event -> model.save());
    }


    private void setupBindings() {

    }

    private void setupValueChangedListeners() {
        HeritagePM proxy = model.getHeritageProxy();

        // disable buttons until some actions are done
        proxy.idProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.intValue() == 0) {
            deleteButton.setDisable(false);
            saveButton.setDisable(false);
            }
        });


        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("predicate: new is " + newValue);
                model.getFilteredData().setPredicate( model.createPredicate(newValue));
        });


    }


}
