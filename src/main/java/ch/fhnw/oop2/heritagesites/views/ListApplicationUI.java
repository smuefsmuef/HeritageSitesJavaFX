package ch.fhnw.oop2.heritagesites.views;


import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ListApplicationUI extends VBox {
    private final PM model;

    // private TableView<PM> tabelle;
    // private Label anzahlGemeinden;


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
        //  tabelle = initializeResultatTabelle();
        //anzahlGemeinden = new Label();
    }

    private TableView<PM> initializeResultatTabelle() {
//        TableView<PM> tableView = new TableView<>(model.getAlleResultate());
//
//        TableColumn<PM, String> idCol = new TableColumn<>("Gemeindenr.");
//        idCol.setCellValueFactory(cell -> cell.getValue().gemeindeNrProperty());
//
//        TableColumn<PM, String> nameCol = new TableColumn<>("Gemeindename");
//        nameCol.setCellValueFactory(cell -> cell.getValue().gemeindeNamenProperty());
//
//        TableColumn<PM, String> cantonCol = new TableColumn<>("Kanton");
//        cantonCol.setCellValueFactory(cell -> cell.getValue().kantonProperty());
//        cantonCol.setCellFactory(param -> new KantonTableCell());
//
//        TableColumn<PM, String> fdpCol = new TableColumn<>("FDP");
//        fdpCol.setCellValueFactory(cell -> cell.getValue().FDPProperty());
//
//        TableColumn<PM, String> CVPCol = new TableColumn<>("CVP");
//        CVPCol.setCellValueFactory(cell -> cell.getValue().CVPProperty());
//
//        TableColumn<PM, String> SPSCol = new TableColumn<>("SPS");
//        SPSCol.setCellValueFactory(cell -> cell.getValue().SPSProperty());
//
//        TableColumn<PM, String> SVPCol = new TableColumn<>("SVP");
//        SVPCol.setCellValueFactory(cell -> cell.getValue().SVPProperty());
//
//        TableColumn<PM, String> LPSCol = new TableColumn<>("LPS");
//        LPSCol.setCellValueFactory(cell -> cell.getValue().LPSProperty());
//
//
//        // egal ob int, long, float, double, die TableColumn hat den Typparameter Number
//        TableColumn<PM, Number> wahlberechtigteCol = new TableColumn<>("Wahlberechtigte");
//        wahlberechtigteCol.setCellValueFactory(cell -> cell.getValue().wahlberechtigteProperty());
//
//        TableColumn<PM, Number> waehlendeCol = new TableColumn<>("W\u00e4hlende");
//        waehlendeCol.setCellValueFactory(cell -> cell.getValue().waehlendeProperty());
//
//        // Variante bei numerischen Werten: Formatieren via asString
//        TableColumn<PM, String> wahlbeteiligungCol = new TableColumn<>("Wahlbeteiligung");
//        wahlbeteiligungCol.setCellValueFactory(cell -> cell.getValue().wahlbeteiligungProperty()
//                .asString(new Locale("de", "CH"), "%.2f %%"));
//
//
//        tableView.getColumns().addAll(idCol, nameCol, cantonCol, fdpCol, CVPCol, SPSCol, SVPCol, LPSCol, wahlberechtigteCol, waehlendeCol, wahlbeteiligungCol);
//
        return null;
//
    }

    private void layoutControls() {
//        setVgrow(tabelle, Priority.ALWAYS);
//
//        getChildren().addAll(tabelle, anzahlGemeinden);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
    }


}
