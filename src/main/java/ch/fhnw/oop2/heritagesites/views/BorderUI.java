package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


// borderUI contains top, center and bottom
// top: to do here
// center --> SplitPane SplitUI
// bottom : to do here (advanced feature)

public class BorderUI extends BorderPane {
    private final PM model;
    private SplitUI split;

    private Button bottomButton;

    HBox hbox = addHBoxTop();
    HBox hboxBottom = addHBoxBottom();


    public BorderUI(PM model) {
        this.model = model;
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        split = new SplitUI(model);
    }

    private void layoutControls() {
        setTop(hbox);
        setCenter(split);
        setBottom(hboxBottom);
    }


    public HBox addHBoxTop() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15));
        hbox.setSpacing(10);

        Button addNewButton = new Button("Add");
        addNewButton.setPrefSize(100, 20);

        Button deleteButton = new Button("Delete");
        deleteButton.setPrefSize(100, 20);

        Button saveButton = new Button("Save");
        saveButton.setPrefSize(100, 20);

        hbox.getChildren().addAll(addNewButton, deleteButton,saveButton );

        return hbox;
    }

    public HBox addHBoxBottom() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15));
        hbox.setSpacing(10);

        bottomButton = new Button("bottom, counter, visited heritages, visited countries");
        bottomButton.setMaxWidth(Double.MAX_VALUE);
        // bottomButton.setPrefSize(500, 20);

        setMargin(bottomButton, new Insets(15));
        hbox.getChildren().addAll(bottomButton);

        return hbox;
    }


}