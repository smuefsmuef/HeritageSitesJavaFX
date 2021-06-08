package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HeaderView extends HBox implements ViewMixin {
    private final WorldHeritagesPM model;
    private Button addNewButton;
    private Button deleteButton;
    private Button saveButton;
    private TextField searchBox;

    public HeaderView(WorldHeritagesPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        addNewButton = new Button("Create Site");
        deleteButton = new Button("Remove Site");
        saveButton = new Button("Save");
        searchBox = new TextField("");
    }

    @Override
    public void layoutControls() {
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

    @Override
    public void setupEventHandlers() {
        // delete site
        deleteButton.setOnAction(event -> model.deleteSite(model.getSelectedHeritageId()));

        // add site
        addNewButton.setOnAction(event -> model.addSite());

        // save current list
        saveButton.setOnAction(event -> model.save());
    }

    @Override
    public void setupValueChangedListeners() {
        HeritagePM proxy = model.getHeritageProxy();

        // disable buttons until some actions are done
        proxy.idProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.intValue() == 0) {
                deleteButton.setDisable(false);
                saveButton.setDisable(false);
            }
        });

        // search bar listener
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("predicate: new is " + newValue);
            model.getFilteredData().setPredicate(model.createPredicate(newValue));
        });
    }

}
