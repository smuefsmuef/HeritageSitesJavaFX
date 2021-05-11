package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HeaderView extends HBox {

        private final PM model;
        
        private Button addNewButton = new Button("+");
        private Button deleteButton = new Button("-");
        private Button saveButton = new Button("Save");


        public HeaderView(PM model) {
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

            // setMargin(hbox, new Insets(5, 2, 5, 2));

            addNewButton.setPrefSize(15, 15);
            addNewButton.setId("addNewButton");

            deleteButton.setPrefSize(15, 15);
            deleteButton.setId("deleteButton");

            saveButton.setPrefSize(100, 15);
            saveButton.setId("saveButton");

            getChildren().addAll(addNewButton, deleteButton, saveButton);

        }

       

        private void setupEventHandlers() {

            // model.addSite();
            // model.deleteSite();

            // todo: with new form on the left, atm add the first one again
            addNewButton.setOnAction(event -> model.addSite());

            // todo: remove the clicked one, bind clicked list element, atm delete first one
            deleteButton.setOnAction(event -> model.getAllSites().remove(0));

            // todo: setup save, changes on the left need to be stored
            saveButton.setOnAction(event -> model.save());

        }


        private void setupBindings() {


        }
    
}
