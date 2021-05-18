package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import com.sun.jdi.Value;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

public class FooterView extends HBox {

    private final WorldHeritagesPM model;

    private Label visitedSites;
    private Label visitedSitesCounter;
    private Label totalSites;
    private Label siteCounter;
    private Label visitedCountries;
    private Label countryCounter;
    private Label visitedCountriesNames;
    private Label countryNameCounter;

    public FooterView(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        setupBindings();
        setupEventHandlers();
    }

    private void initializeControls() {

    }

    private void layoutControls() {
        setPadding(new Insets(5, 5, 5, 10));
        setSpacing(10);

        setId("bottom");

        totalSites = new Label("Sites total: ");
        // ok so, to get the init value, note that for the other ones it doesnt matter atm, no stored values in db
        siteCounter = new Label(" " + model.getTotalSites());

        visitedSites = new Label("Sites visited: ");
        visitedSitesCounter = new Label(" ");

        visitedCountries = new Label("Countries visited I:");
        countryCounter = new Label("");

        visitedCountriesNames = new Label("Countries visited II:");
        countryNameCounter = new Label("");

        getChildren().addAll(totalSites, siteCounter, visitedSites, visitedSitesCounter, visitedCountries, countryCounter, visitedCountriesNames, countryNameCounter);
    }


    private void setupEventHandlers() {

    }


    private void setupBindings() {
        siteCounter.textProperty().bind(model.sitesCounterProperty().asString());
        visitedSitesCounter.textProperty().bind(model.visitedSitesProperty().asString());
        countryCounter.textProperty().bind(model.visitedCountriesProperty().asString());
        countryNameCounter.textProperty().bind(model.visitedCountriesNamesProperty());
    }

}
