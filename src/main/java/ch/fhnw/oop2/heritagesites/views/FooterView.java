package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FooterView extends HBox implements ViewMixin {
    private final WorldHeritagesPM model;
    private Label visitedSitesCounter;
    private Label siteCounter;
    private Label countryCounter;
    private Label countryNameCounter;
    private Label visitedSites;
    private Label visitedCountries;
    private Label visitedCountriesNames;
    private Label totalSites;

    public FooterView(WorldHeritagesPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        totalSites = new Label("Sites total: ");
        siteCounter = new Label(" " + model.totalSites());
        // to get the init value,
        // note that for the other ones it doesnt matter atm, no stored values in db

        visitedSites = new Label("Sites visited: ");
        visitedSitesCounter = new Label(" ");

        visitedCountries = new Label("Countries visited I:");
        countryCounter = new Label("");

        visitedCountriesNames = new Label("Countries visited II:");
        countryNameCounter = new Label("");
    }

    @Override
    public void layoutControls() {
        setPadding(new Insets(5, 5, 5, 10));
        setSpacing(10);
        getChildren().addAll(totalSites, siteCounter, visitedSites, visitedSitesCounter, visitedCountries, countryCounter, visitedCountriesNames, countryNameCounter);
    }

    @Override
    public void setupBindings() {
        siteCounter.textProperty().bind(model.sitesCounterProperty().asString());
        visitedSitesCounter.textProperty().bind(model.visitedSitesProperty().asString());
        countryCounter.textProperty().bind(model.visitedCountriesProperty().asString());
        countryNameCounter.textProperty().bind(model.visitedCountriesNamesProperty());
    }

}
