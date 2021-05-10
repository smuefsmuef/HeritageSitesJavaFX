package ch.fhnw.oop2.heritagesites.views;


import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.concurrent.Callable;

public class FormApplicationUI extends GridPane {
    private final PM model;
    public ListApplicationUI test; // todo: when table left changes (by click f.e.) then update here
    private Label title;

    private Label siteLabel;
    private TextField siteField;
    private Label dateInscribedLabel;
    private TextField dateInscribedField;
    private Label categoryLabel;
    private TextField categoryField;
    private Label locationLabel;
    private TextField locationField;
    private Label regionLabel;
    private TextField regionField;
    private Label statesLabel;
    private TextField statesField;
    private Label descriptionLabel;
    private TextArea descriptionField;
    private Label codeISOLabel;
    private TextField codeISOField;
    private Label imageURLLabel;
    private Hyperlink imageURLField;
    private Label visitedLabel;
    private CheckBox visitedField;



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
        test = new ListApplicationUI(model);

        title = new Label("rechte seite");

        //
        siteLabel = new Label("Name");
        dateInscribedLabel = new Label("Year Inscribed");
        categoryLabel = new Label("Category");
        locationLabel = new Label("Location");
        regionLabel = new Label("Region");
        statesLabel = new Label("States");
        descriptionLabel = new Label("Short Description");
        codeISOLabel = new Label("ISO Code");
        imageURLLabel = new Label("Image URL");
        visitedLabel = new Label("Visited");

        // todo atm 0 --> change to the clicked one
        System.out.println(test.getIdSite()); // this is correct, gets the right value, but we need to update it
        siteField = new TextField(model.getAllSites().get(test.getIdSite()).getSite());
        dateInscribedField = new TextField();
        regionField = new TextField();
        codeISOField = new TextField();
        imageURLField = new Hyperlink(model.getAllSites().get(0).getImgageURL());
        visitedField = new CheckBox();
        categoryField = new TextField();
        locationField = new TextField();
        dateInscribedField = new TextField();
        descriptionField = new TextArea(model.getAllSites().get(0).getDescription());
        statesField = new TextField();

        descriptionField.setId("descriptionField");
    }


    private void layoutControls() {
        // general stuff
        setPadding(new Insets(10));

        // title
        setMargin(title, new Insets(5,0,5,0));
        title.setId("formTitle");


        //// Form table

        // column constraints
        ColumnConstraints cc = new ColumnConstraints();
        cc.setMinWidth(120);
        ColumnConstraints ccHgrow = new ColumnConstraints();
        ccHgrow.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, ccHgrow);

        // row constraints
        RowConstraints rc = new RowConstraints();
        RowConstraints rcVgrow = new RowConstraints();
        rcVgrow.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rcVgrow, rc, rc, rc);


        // gridPane.add(Node, columnIndex, rowIndex, colspan, rowspan);
        add(title, 0, 0, 2, 1);

        add(siteLabel, 0, 1, 1, 1);
        add(siteField, 1, 1, 1, 1);

        add(dateInscribedLabel, 0, 2, 1, 1);
        add(dateInscribedField, 1, 2, 1, 1);

        add(categoryLabel, 0, 3, 1, 1);
        add(categoryField, 1, 3, 1, 1);

        add(locationLabel, 0, 4, 1, 1);
        add(locationField, 1, 4, 1, 1);

        add(regionLabel, 0, 5, 1, 1);
        add(regionField, 1, 5, 1, 1);

        add(statesLabel, 0, 6, 1, 1);
        add(statesField, 1, 6, 1, 1);

        add(descriptionLabel, 0, 7, 1, 1);
        add(descriptionField, 1, 7, 1, 1);

        add(codeISOLabel, 0, 8, 1, 1);
        add(codeISOField, 1, 8, 1, 1);

        add(imageURLLabel, 0, 9, 1, 1);
        add(imageURLField, 1, 9, 1, 1);

        add(visitedLabel, 0, 10, 1, 1);
        add(visitedField, 1, 10, 1, 1);

        descriptionField.setWrapText(true);



    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {

    }

    private void setupBindings() {
        // title
    }


}
