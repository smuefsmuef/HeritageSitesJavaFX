package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import static javafx.scene.layout.HBox.setHgrow;

// todo: everything seems fine here

public class ListApplicationUI extends VBox {
    private final PM model;
    private TableView<HeritagePM> tableHeritage;

    public int idSite; // update


    public ListApplicationUI(PM model) {
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
        // todo: maybe move to layoutControls();
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

        // System.out.println(tableView.getSelectionModel().getSelectedCells());


        return tableView;
    }

    private void layoutControls() {
        setVgrow(tableHeritage, Priority.ALWAYS);
        getChildren().addAll(tableHeritage);

        tableHeritage.setId("heritageTable");
        setMargin(tableHeritage, new Insets(10));


    }

    private void setupEventHandlers() {
        // todo: click on list element opens the event on the right

        tableHeritage.setOnMouseClicked(event -> {


            System.out.println("hallooo, laufscvh=?");
            System.out.println(event);

            // todo somethning is worng here
            TableCell c = (TableCell) event.getTarget();
            int index = c.getIndex();

            System.out.println("id = " + model.getAllSites().get(index).getSite());
            System.out.println("id = " + model.getAllSites().get(index).getId());

            // String id = model.getAllSites().get(index).getId();
            setIdSite(index);

        });


    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }
}
