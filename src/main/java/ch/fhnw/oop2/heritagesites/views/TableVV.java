package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TableVV extends VBox {
    private final WorldHeritagesPM model;
    private TableView<HeritagePM> tableHeritage;
    private TableView<HeritagePM> tableView;


    public TableVV(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupValueChangedListeners();
        setupBindings();
    }

    public void initializeControls() {
        tableView = new TableView<>(model.getSortedList());
        tableHeritage = initializeTable(tableView);
    }

    private TableView<HeritagePM> initializeTable(TableView<HeritagePM> tableView) {
        tableView.setEditable(true);

        TableColumn<HeritagePM, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(cell -> cell.getValue().siteProperty());
        name.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<HeritagePM, String> category = new TableColumn<>("Category");
        category.setCellValueFactory(cell -> cell.getValue().categoryProperty());
        category.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<HeritagePM, String> country = new TableColumn<>("Country");
        country.setCellValueFactory(cell -> cell.getValue().codeISOProperty());
        country.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<HeritagePM, String> states = new TableColumn<>("States");
        states.setCellValueFactory(cell -> cell.getValue().statesProperty());
        states.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<HeritagePM, String> id = new TableColumn<>("ID");
        id.setCellValueFactory(cell -> cell.getValue().idProperty().asString());
        id.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<HeritagePM, Boolean> visited = new TableColumn<>(" ");
        visited.setCellValueFactory(cell -> cell.getValue().visitedProperty());
        visited.setCellFactory(param -> new SiteTableCell()); // update Cells

        tableView.getColumns().addAll(visited, id, name, category, country, states);

        // layout of the table

        // set id's'
        name.setId("name");
        category.setId("category");
        country.setId("country");
        states.setId("states");
        id.setId("id");
        tableView.setId("tableView");

        visited.textProperty().bind(model.visitedSitesProperty().asString());

        // bind columnsize to width
        name.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));
        category.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        country.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        states.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        id.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));

        // event handler
        // edit some table columns: Name, Category, Country, State

        name.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<HeritagePM, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<HeritagePM, String> t) {
                        ((HeritagePM) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSite(t.getNewValue());
                    }
                }
        );

        states.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<HeritagePM, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<HeritagePM, String> t) {
                        ((HeritagePM) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStates(t.getNewValue());
                    }
                }
        );

        category.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<HeritagePM, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<HeritagePM, String> t) {
                        ((HeritagePM) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCategory(t.getNewValue());
                    }
                }
        );

        country.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<HeritagePM, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<HeritagePM, String> t) {
                        ((HeritagePM) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCodeISO(t.getNewValue());
                    }
                }
        );

        return tableView;
    }

    private void layoutControls() {
        setVgrow(tableHeritage, Priority.ALWAYS);
        getChildren().addAll(tableHeritage);
        tableHeritage.setId("heritageTable");
        setMargin(tableHeritage, new Insets(7));
    }

    private void setupValueChangedListeners() {
        tableHeritage.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            model.setSelectedHeritageId(newValue.getId());
        });
    }

    private void setupBindings() {
        model.getSortedList().comparatorProperty().bind(tableHeritage.comparatorProperty());
    }

}



