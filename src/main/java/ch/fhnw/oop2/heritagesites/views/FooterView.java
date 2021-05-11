package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.w3c.dom.Text;

public class FooterView extends HBox {

    private final PM model;

    private Label visitedSites;
    private Label visitedSitesCounter;
    private Label totalSites;
    private Label siteCounter;
    private Label visitedCountries;
    private Label countryCounter;

    public FooterView(PM model) {
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


    }

}
