package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
        setPadding(new Insets(5, 5,5, 10));
        setSpacing(10);

        setId("bottom");

        visitedSites = new Label("Sites visited: ");
        visitedSitesCounter = new Label(" " + model.getVisitedSitesCounter());

        totalSites = new Label("Sites total: ");
        siteCounter = new Label(" " + model.getTotalSites());

        visitedCountries = new Label("Countries visited:");
        countryCounter = new Label("" + model.getVisitedCountriesCounter());

        getChildren().addAll(visitedSites, visitedSitesCounter, totalSites, siteCounter, visitedCountries, countryCounter);
    }


    private void setupEventHandlers() {

    }


    private void setupBindings() {
        System.out.println(model.getVisitedCountriesCounter());
        visitedSitesCounter.textProperty().bind(new SimpleIntegerProperty(model.getVisitedSitesCounter()).asString());


    }

}
