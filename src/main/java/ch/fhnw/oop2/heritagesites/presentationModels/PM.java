package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.swing.*;

public class PM {

    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");

    private final StringProperty  gemeindeNr      = new SimpleStringProperty();
    private final StringProperty  gemeindeNamen   = new SimpleStringProperty();
    private final StringProperty  kanton          = new SimpleStringProperty();
    private final StringProperty  FDP             = new SimpleStringProperty();
    private final StringProperty  CVP             = new SimpleStringProperty();



    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }
}


