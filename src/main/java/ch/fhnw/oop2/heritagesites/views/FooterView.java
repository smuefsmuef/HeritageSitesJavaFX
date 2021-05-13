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

        visitedSites = new Label("Sites visited: ");
        visitedSitesCounter = new Label(" ");

        totalSites = new Label("Sites total: ");
        siteCounter = new Label(" " + model.getTotalSites());

        visitedCountries = new Label("Countries visited:");
        countryCounter = new Label("");

        getChildren().addAll(visitedSites, visitedSitesCounter, totalSites, siteCounter, visitedCountries, countryCounter);
    }


    private void setupEventHandlers() {

    }


    private void setupBindings() {
        visitedSitesCounter.textProperty().bind(model.visitedSitesProperty().asString());
        countryCounter.textProperty().bind(model.visitedCountriesProperty().asString());
    }

}
