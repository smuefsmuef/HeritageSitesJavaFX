package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

// todo: everything seems fine here

public class TableVV extends VBox {
    private final WorldHeritagesPM model;
    private TableView<HeritagePM> tableHeritage;


    public TableVV(WorldHeritagesPM model) {
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
        tableHeritage = initializeTable();
    }

    private TableView<HeritagePM> initializeTable() {
        TableView<HeritagePM> tableView = new TableView<>(model.getAllSites());

        TableColumn<HeritagePM, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(cell -> cell.getValue().siteProperty());

        TableColumn<HeritagePM, String> category = new TableColumn<>("Category");
        category.setCellValueFactory(cell -> cell.getValue().categoryProperty());

        TableColumn<HeritagePM, String> country = new TableColumn<>("Country");
        country.setCellValueFactory(cell -> cell.getValue().codeISOProperty());

        TableColumn<HeritagePM, String> states = new TableColumn<>("States");
        states.setCellValueFactory(cell -> cell.getValue().statesProperty());

        tableView.getColumns().addAll(name, category, country, states);


        // layout of the table

        // set id's'
        name.setId("name");
        category.setId("category");
        country.setId("country");
        states.setId("states");
        tableView.setId("tableView");

        // bind columnsize to width
        name.prefWidthProperty().bind(tableView.widthProperty().multiply(0.6));
        category.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        country.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        states.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));

        return tableView;
    }

    private void layoutControls() {
        setVgrow(tableHeritage, Priority.ALWAYS);
        getChildren().addAll(tableHeritage);
        tableHeritage.setId("heritageTable");
        setMargin(tableHeritage, new Insets(7));
    }

    private void setupEventHandlers() {

    }

    private void setupValueChangedListeners() {

        tableHeritage.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("new id: " + newValue.getId());
            model.setSelectedHeritageId(newValue.getId());
        });
    }

    private void setupBindings() {
    }

}



