package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FooterView extends HBox {
    private final WorldHeritagesPM model;

    private Label visitedSitesCounter;
    private Label siteCounter;
    private Label countryCounter;
    private Label countryNameCounter;

    public FooterView(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
    }

    private void initializeControls() {
        Label totalSites = new Label("Sites total: ");
        siteCounter = new Label(" " + model.totalSites());         // to get the init value, note that for the other ones it doesnt matter atm, no stored values in db

        Label visitedSites = new Label("Sites visited: ");
        visitedSitesCounter = new Label(" ");

        Label visitedCountries = new Label("Countries visited I:");
        countryCounter = new Label("");

        Label visitedCountriesNames = new Label("Countries visited II:");
        countryNameCounter = new Label("");

        getChildren().addAll(totalSites, siteCounter, visitedSites, visitedSitesCounter, visitedCountries, countryCounter, visitedCountriesNames, countryNameCounter);
    }

    private void layoutControls() {
        setPadding(new Insets(5, 5, 5, 10));
        setSpacing(10);
    }

    private void setupBindings() {
        siteCounter.textProperty().bind(model.sitesCounterProperty().asString());
        visitedSitesCounter.textProperty().bind(model.visitedSitesProperty().asString());
        countryCounter.textProperty().bind(model.visitedCountriesProperty().asString());
        countryNameCounter.textProperty().bind(model.visitedCountriesNamesProperty());
    }

}
