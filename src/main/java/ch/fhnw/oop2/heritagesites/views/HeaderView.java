package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HeaderView extends HBox {

    private final WorldHeritagesPM model;

    private Button addNewButton = new Button("Create Site");
    private Button deleteButton = new Button("Remove Site");
    private Button saveButton = new Button("Save new Site");


    public HeaderView(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
        setupEventHandlers();
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

        getChildren().addAll(addNewButton, saveButton, deleteButton);

    }


    private void setupEventHandlers() {

//selectionModel.clearSelection();


        // delete, ok
        deleteButton.setOnAction(event -> model.deleteSite(model.getSelectedHeritageId()));

        // todo: open a new empty form, mayve -1
        addNewButton.setOnAction(event -> model.addSite());


        // todo: save stored values and add to list
        saveButton.setOnAction(event -> model.saveSite());

    }


    private void setupBindings() {


    }

}
